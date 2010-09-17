    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rlwcompiler2010;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cristian
 */
public class Rlwlex {

    private int l = 1; // current line
    private int index = 0; // position src file
    private String strip = ""; // readed chars "buffer"
    private String source; // src ln (from src file)
    private String filePath;
    private State state; // current state
    private State s0; // initial state
    private Vector<Token> tokenStrip;
    private FileReader fr;
    private BufferedReader br;

    Rlwlex(String filePath) throws Exception {
        this.filePath = filePath;
        tokenStrip = new Vector<Token>();

        fr = new FileReader(filePath);
        br = new BufferedReader(fr);

        //set the automata
        s0 = new State(null);
        ITokenizer kwt = new KeywordTokenizer(this);
        ITokenizer idt = new IdTokenizer(this);
        ITokenizer it = new IntTokenizer(this);
        ITokenizer div = new DivisionTokenizer(this);
        ITokenizer lct = new LogicCompTokenizer(this);
        ITokenizer sngt = new SingleTokenizer(this);
        ITokenizer asgt = new AsignTokenizer(this);
        ITokenizer sft = new FloatTonkenizer(this);
        RCTokenizer rct = new RCTokenizer();
        rct.add(kwt);
        rct.add(idt);

        State kw = new State(kwt), //representa Validacion de KeyWords
                id = new State(idt), //representa Validacion de ID
                integer = new State(it), //representa Validacion de Constante Integer
                start_div = new State(div),
                com_less = new State(lct),
                com_great = new State(lct),
                com_equal = new State(lct),
                singles = new State(sngt),
                end_asign = new State(asgt),//FINAL

                comment = new State(null),// null tokenaizer los comentarios se ignoran
                start_asign = new State(null),//null tokenizer estado intermedio asign
                floating = new State(null), // null tokenize intermedio del float
                floatexp = new State(null),// null tokenizer obliga a tener exp desp del E y detec sign
                textstrip = new State(null),// nul tokenizer estado intermedio hasta "

                spif = new State(null),//null tokenizer space post int
                spef = new State(null),//null tokenizer space post exp (E)
                // estos dos ultimos todavia no se usan
                // son los espacios para float const con E
                // ahora los float son 2E4 3.5E8

                sfloatexp = new State(sft);

        String schar = "[a-zA-Z]",
                dig = "[0-9]",
                goat = "\\.",
                spa = "\\s",
                exp = "E",
                mdd = ":",
                nnl = "[^(\\r\\n|\\n)]",
                nl = "(\\r\\n|\\n)",
                bl = "(\\s|\\t|\\r\\n|\\n)",
                ms = "^\\-$",
                dq = "[\"]",
                ndq = "[^\"]",
                sb = "/",
                cg = "\\>",
                cl = "\\<",
                ce = "=",
                sg = "(\\*|\\+|-|;|,|\\(|\\)|\\{|\\})";

        s0.addTrans(schar, kw);
        s0.addTrans(dig, integer);
        s0.addTrans(goat, floating);
        s0.addTrans(mdd, start_asign);
        s0.addTrans(sb, start_div);
        s0.addTrans(cg, com_great);
        s0.addTrans(cl, com_less);
        s0.addTrans(ce, com_equal);
        s0.addTrans(sg, singles);
        s0.addTrans(cl, com_less);
        s0.addTrans(ce, com_equal);
        s0.addTrans(sg, singles);
        s0.addTrans(dq, textstrip);

        textstrip.addTrans(ndq, textstrip);
        start_div.addTrans(sb, comment);//doble barra ->comentario
        comment.addTrans(nnl, comment);

        com_less.addTrans(ce, com_equal);// < <> <=
        com_great.addTrans(ce, com_equal);// > >=
        start_asign.addTrans(ms, end_asign); // :-

        kw.addTrans(dig, id);
        kw.addTrans(schar, kw);
        id.addTrans(schar, id);
        id.addTrans(dig, id);


        // lo referido al float es altamente dudoso
        integer.addTrans(dig, integer);
        integer.addTrans(exp, floatexp);
        integer.addTrans(goat, floating);
        floating.addTrans(dig, floating);
        floating.addTrans(exp, floatexp);
        floatexp.addTrans(dig, sfloatexp);
        floatexp.addTrans(ms, sfloatexp);
        sfloatexp.addTrans(dig, sfloatexp);


        state = s0;
    }

    protected String nextLine() {
        String s = null;
        try {
            s = br.readLine();
            if (s == null) {
                fr.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    protected Token nextToken() {
        Token t = null;

        while (t == null) {
            if (source == null || source.length() <= index) {
                source = nextLine();
                index = 0;
                if (source == null) {
                    //
                    return makeToken(strip);
                }
            }
            char c = source.charAt(index++);
            State ns = state.next(c);

            if (ns != null) { // si tengo transicion, todo va bien
                strip += c;
                state = ns;
            } else {// si no tengo prox estado es final (valido-ERROR)
                t = makeToken(strip);
                //corregir index y strip pa que salga andando
                // el char actual es el que no valida con el estado acutal -> proximo token
                strip = String.valueOf(c);
                // salteo de vacios (solo entre tokens)
                while (strip.matches("\\t\\s\\n")) {
                    if (source == null || source.length() <= index) {
                        source = nextLine();
                        index = 0;
                        if (source == null) {

                            return makeToken(strip);
                        }
                    }
                    c = source.charAt(index++);
                    strip = String.valueOf(c);
                }
                state = s0.next(c);
            }
            //TODO
            //if(String.valueOf(c).matches(nl))
            // l++;
        }
        return t;
    }

    public void log(String s) {
        System.out.println("Line <" + l + ">: " + s);
    }

    private Token makeToken(String strip) {
        Token t = state.getToken(strip);
        if (t != null) {
            // buscar en tsimbolo
            //    si no ta agregar
            tokenStrip.add(t);
        }
        return t;
    }

    static public void main(String[] args) throws FileNotFoundException {
        test();
    }


    static private void test() {
        // SI TENEMOS PROBLEMAS CON LOS FIN DE LINEA TENEMOS PROBLEMAS SERIOS
        Rlwlex lex = null;
        try {
            lex = new Rlwlex("pito.pt");
        } catch (Exception ex) {
            Logger.getLogger(Rlwlex.class.getName()).log(Level.SEVERE, null, ex);
        }
        lex.log("probando con pito.pt!");

        String s = "";
        int c=0;
        do {
            s = lex.nextLine();
            System.out.println(s+(s!=null&&s.endsWith("\n")?" "
                    +" ("+(++c)+","+lex.l+")":""));
        } while (s != null);

    }

    static private void test2(){
       Token t = null;

        while (t == null){
        Rlwlex lex = null;
        try {
            lex = new Rlwlex("pito.pt");
        } catch (Exception ex) {
            Logger.getLogger(Rlwlex.class.getName()).log(Level.SEVERE, null, ex);
        }

        String source = lex.nextLine();
        String strip = "";
        int  index = 0;
            char c = source.charAt(index++);
            State ns = lex.state.next(c);

            if (ns != null) { // si tengo transicion, todo va bien
                System.out.println(lex.state!=ns?"CAMBIO DE ESTADO por "+c:"SEGUIMOS "+strip);
                strip += c;
                lex.state = ns;
            } else {// si no tengo prox estado es final (valido-ERROR)
                t = lex.makeToken(strip);
                System.out.println(t==null?"TOKEN ERRONEO con "+strip:"TOKEN LISTO "+t);

                //corregir index y strip pa que salga andando
                // el char actual es el que no valida con el estado acutal -> proximo token
                strip = String.valueOf(c);
                // salteo de vacios (solo entre tokens)
                while (strip.matches("cualquier tipo de blanco")) {
                    if (source == null || source.length() <= index) {
                        source = lex.nextLine();
                        index = 0;
                        if (source == null) {
                            System.out.println("Nos quedamos sin testo, filazando prueba");
                            return;
                        }
                    }
                    c = source.charAt(index++);
                    strip = String.valueOf(c);
                }
                lex.state = lex.s0.next(c);
            }
        }
    }


    static private void test3() {
        Rlwlex lex = null;
        try {
            lex = new Rlwlex("pito.pt");
        } catch (Exception ex) {
            Logger.getLogger(Rlwlex.class.getName()).log(Level.SEVERE, null, ex);
        }
        lex.log("probando con pito.pt!");
        Token t = null;
        do {
            t = lex.nextToken();
            System.out.println("Encontrado " + t);
        } while (t != null);
    }
}

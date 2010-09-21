    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rlwcompiler2010;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/* Incluir en el CLASS_PATH a CUP */
import java_cup.runtime.Scanner;
import java_cup.runtime.Symbol;

/**
 *
 * @author cristian
 */
public class Rlwlex implements Scanner {

    private int l = 0; // current line
    private int index = 0; // position src file
    private String strip = ""; // readed chars "buffer"
    private String source; // src ln (from src file)
    private String filePath;
    private State state; // current state
    private State s0; // initial state
    private Hashtable<String,SymbolData> ts;
    private Vector<Token> tokenStrip;
    private FileReader fr;
    private BufferedReader br;

    Rlwlex(String filePath) throws Exception {
        System.out.println("Lexer:: Trying to open file \"" + filePath + "\"");
        this.filePath = filePath;
        this.ts = new Hashtable<String, SymbolData>();
        tokenStrip = new Vector<Token>();

        fr = new FileReader(filePath);
        br = new BufferedReader(fr);

        //set the automata
        s0 = new State(null);
        ITokenizer kwt = new KeywordTokenizer(this),
                idt = new IdTokenizer(this),
                it = new IntTokenizer(this),
                div = new DivisionTokenizer(this),
                lct = new LogicCompTokenizer(this),
                sngt = new SingleTokenizer(this),
                asgt = new AsignTokenizer(this),
                sft = new FloatTokenizer(this),
                st = new StringTokenizer(this);
        RCTokenizer rct = new RCTokenizer();
        rct.add(kwt);
        rct.add(idt);

        State kw = new State(rct), //representa Validacion de KeyWords
                id = new State(idt), //representa Validacion de ID
                integer = new State(it), //representa Validacion de Constante Integer
                start_div = new State(div),
                com_less = new State(lct),
                com_great = new State(lct),
                com_equal = new State(lct),
                singles = new State(sngt),
                end_asign = new State(asgt),//FINAL
                start_asign = new State(new TokenErrorInformer(this,"ERROR: se esperaba \"-\" despues de")),//null tokenizer estado intermedio asign
                tsend = new State(st),//HACE FALTA EL TOKENIZER!!!!!!!
                textstrip = new State(new TokenErrorInformer(this,"ERROR: cadena de texto incompleta")),//null token hasta el "

                comment = new State(null),// null tokenaizer los comentarios se ignoran
                
                floating = new State(sft),
                pmsfloatexp = new State(new TokenErrorInformer(this,"ERROR: secuencia no reconocida, posible CONST_REAL")),
                post_intspace = new State(it),
                post_floatspace = new State(sft),
                pre_floatexp = new State(new TokenErrorInformer(this,"ERROR: secuencia no reconocida, posible CONST_REAL")),// null? para "2.3 E "
                floatexp = new State(sft);// es el pre E deberia poder construir Float o Int
// null tokenizer obliga a tener exp desp del E y detec sign
             
        String schar = "[a-zA-Z]",
                dig = "[0-9]",
                goat = "\\.",
                spa = "[ \\t]",
                exp = "E",
                mdd = ":",
                nnl = "[^\\n]",
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
        
        textstrip.addTrans(dq, tsend);
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
        integer.addTrans(goat,floating);
        integer.addTrans(exp, pre_floatexp);
        integer.addTrans(spa, post_intspace);
        // floating point
        floating.addTrans(dig, floating);
        floating.addTrans(exp, pre_floatexp);
        floating.addTrans(spa, post_floatspace);
        //ilimitaed spaces before E
        post_floatspace.addTrans(spa,post_floatspace);
        post_floatspace.addTrans(exp,pre_floatexp);
        //ilimitaed spaces before E int tokenizer
        post_intspace.addTrans(spa,post_intspace);
        post_intspace.addTrans(exp,pre_floatexp);
        //spa dig sign -> post E space finishes
        pre_floatexp.addTrans(spa,pre_floatexp);
        pre_floatexp.addTrans(ms,pmsfloatexp);
        pre_floatexp.addTrans(dig,floatexp);
        //postsign space
        pmsfloatexp.addTrans(spa, pmsfloatexp);
        pmsfloatexp.addTrans(dig,floatexp);
        //exp
        floatexp.addTrans(dig,floatexp);


        state = s0;
    }

    protected String nextLine() {
        String s = null;
        try {
            s = br.readLine();
            if (s == null) {
                fr.close();
                return s;
            }
                l++;
                s += "\n";
           
        } catch (Exception e) {
    //        e.printStackTrace();
        }
        return s;
    }

    @Override
    public Symbol next_token() throws Exception {
        Token t= nextToken();
        if (t != null) {
            System.out.println("Lexer:: Returning token " + t.get());
            return new Symbol(t.get(), t.getString());
        }
        System.out.println("Lexer:: Returning END-OF-FILE (hippies)");
        return new Symbol(Symbols.EOF);

    }

    protected Token nextToken() {
        Token t = null;

        while (t == null) {
            if (source == null || source.length() <= index) {
                source = nextLine();
                index = 0;
                if (source == null) {
                    //Corte de emergencia
                    t = makeToken(strip);
                    strip = "";
                    return t;
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
                while (strip.matches("[ \\t\\n]*")) {
                    if (source == null || source.length() <= index) {
                        source = nextLine();
                        index = 0;
                        if (source == null) {
                            return t;
                        }
                    }
                    c = source.charAt(index++);
                    strip = String.valueOf(c);
                }
                //salta caracteres fallidos ;)
                state = s0.next(c);
                if (state == null) {
                    log("ERROR: token no reconocido " + c);
                    strip = "";
                    state = s0;
                }
            }
        }
        return t;
    }

    public void log(String s) {
        System.out.println("Line <" + l + ">: " + s);
    }

    private Token makeToken(String strip) {
        Token t = state.getToken(strip);
        Iterator<String> it;
        if (t != null) {
            if(t.get() == Symbols.IDENTIFIER){
                it=ts.keySet().iterator();
                String alphaString = null;
                while(it.hasNext()&&alphaString==null){
                    alphaString=it.next();
                    if(t.matches(alphaString)){

                    }else{
                        alphaString=null;
                    }
                }
            }
            // buscar en tsimbolo
            //    si no ta agregar
            tokenStrip.add(t);
        }
        return t;
    }

    static public void main(String[] args) throws FileNotFoundException {
        test2();
    }

    static private void test() {
        // SI TENEMOS PROBLEMAS CON LOS FIN DE LINEA TENEMOS PROBLEMAS SERIOS
        Rlwlex lex = null;
        try {
            lex = new Rlwlex("test.txt");
        } catch (Exception ex) {
            Logger.getLogger(Rlwlex.class.getName()).log(Level.SEVERE, null, ex);
        }
        lex.log("probando con test.txt!");

        String s = "";
        int c = 0;
        do {
            s = lex.nextLine();

            if (s != null && s.endsWith("\n")) {
                System.out.println("con n");

            }
            if (s != null && s.endsWith("\r\n")) {
                System.out.println("con r");
                //   System.out.println(s + (s != null && s.endsWith("\n") ? " "
                //           + " (" + (++c) + "," + lex.l + ")" : ""));
                
            }
        } while (s != null);

    }

    static private void test2() {
        Token t = null;
        Rlwlex lex = null;
        try {
            lex = new Rlwlex("pitogordo.txt");
        } catch (Exception ex) {
            Logger.getLogger(Rlwlex.class.getName()).log(Level.SEVERE, null, ex);
        }
        do {
            try {
                t = lex.nextToken();
           //     System.out.println(t.get() + " " + t.getString());
            } catch (Exception e) {
                //              e.printStackTrace();
            }
        } while (t != null);

        for(Token t2 : lex.tokenStrip)
            System.out.println("("+t2.get()+")"+t2.getString());


    }

    static private void test3() {
        Rlwlex lex = null;
        try {
            lex = new Rlwlex("test.txt");
        } catch (Exception ex) {
            Logger.getLogger(Rlwlex.class.getName()).log(Level.SEVERE, null, ex);
        }
        lex.log("probando con test.txt!");
        Token t = null;
        do {
            t = lex.nextToken();
            System.out.println("Encontrado " + t);
        } while (t != null);
    }
}

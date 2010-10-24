   /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rlwcompiler2010;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;


/* Incluir en el CLASS_PATH a CUP */
import java_cup.runtime.Scanner;
import java_cup.runtime.Symbol;

/**
 *
 * @author cristian
 */
public class Rlwlexer implements Scanner {
    private int l = 1; // current line
    private int index = 1; // position in line
    private String strip = ""; // readed chars "buffer"
    private String filePath;
    private State state; // current state
    private State s0,// initial state
            blanks,comment;
    private Hashtable<String, SymbolData> ts;
    private Vector<Token> tokenStrip;
    private FileReader fr;
    private BufferedReader br;
    private static Rlwlexer lexer = null;

    public static void initLexer(String filePath) throws Exception {
        lexer = new Rlwlexer(filePath);
    }

    public static Rlwlexer getLexer() {
        return lexer;
    }

    private Rlwlexer(String filePath) throws Exception {
        Logger.get().logDebug("Lexer", "Trying to open file \"" + filePath + "\"");
        this.filePath = filePath;
        this.ts = new Hashtable<String, SymbolData>();
        tokenStrip = new Vector<Token>();

        fr = new FileReader(filePath);
        br = new BufferedReader(fr);

        //set the automata
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

        s0 = new State(null);//estado inicial
        blanks =  new State(null);//null tokenizer, los espacios se ignoran
        comment = new State(null);// null tokenaizer los comentarios se ignoran

        State   kw = new State(rct), //representa Validacion de KeyWords
                integer = new State(it), //representa Validacion de Constante Integer
                start_div = new State(div),
                com_less = new State(lct),
                com_great = new State(lct),
                com_equal = new State(lct),
                singles = new State(sngt),
                end_asign = new State(asgt),
                start_asign = new State(new TokenErrorInformer(this, "ERROR: \'-\' expected after")),
                tsend = new State(st),
                textstrip = new State(new TokenErrorInformer(this, "ERROR: Incomplete string")),
                floating = new State(sft),
                pmsfloatexp = new State(new TokenErrorInformer(this, "ERROR: Unrecognised sequence (might be a float constant?)")),
                post_intspace = new State(it),
                post_floatspace = new State(sft),
                pre_floatexp = new State(new TokenErrorInformer(this, "ERROR: Unrecognised sequence (might be a float constant?)")),// null? para "2.3 E "
                floatexp = new State(sft);

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

        s0.addTrans(bl, blanks);
        s0.addTrans(schar, kw);
        s0.addTrans(dig, integer);
        s0.addTrans(goat, floating);
        s0.addTrans(mdd, start_asign);
        s0.addTrans(sb, start_div);
        s0.addTrans(cg, com_great);
        s0.addTrans(cl, com_less);
        s0.addTrans(ce, com_equal);
        s0.addTrans(sg, singles);
        s0.addTrans(dq, textstrip);

        textstrip.addTrans(ndq, textstrip);

        blanks.addTrans(bl, blanks);

        textstrip.addTrans(dq, tsend);
        start_div.addTrans(sb, comment);
        comment.addTrans(nnl, comment);

        com_less.addTrans(ce, com_equal);// < <> <=
        com_less.addTrans(cg, com_equal);// > >=
        com_great.addTrans(ce, com_equal);// > >=
        start_asign.addTrans(ms, end_asign); // :-

        kw.addTrans(schar, kw);
        kw.addTrans(dig, kw);

        integer.addTrans(dig, integer);
        integer.addTrans(goat, floating);
        integer.addTrans(exp, pre_floatexp);
        integer.addTrans(spa, post_intspace);
        // floating point
        floating.addTrans(dig, floating);
        floating.addTrans(exp, pre_floatexp);
        floating.addTrans(spa, post_floatspace);
        //ilimitaed spaces before E
        post_floatspace.addTrans(spa, post_floatspace);
        post_floatspace.addTrans(exp, pre_floatexp);
        //ilimitaed spaces before E int tokenizer
        post_intspace.addTrans(spa, post_intspace);
        post_intspace.addTrans(exp, pre_floatexp);
        //spa dig sign -> post E space finishes
        pre_floatexp.addTrans(spa, pre_floatexp);
        pre_floatexp.addTrans(ms, pmsfloatexp);
        pre_floatexp.addTrans(dig, floatexp);
        //postsign space
        pmsfloatexp.addTrans(spa, pmsfloatexp);
        pmsfloatexp.addTrans(dig, floatexp);
        //exp
        floatexp.addTrans(dig, floatexp);


        state = s0;
    }

    @Override
    public Symbol next_token() throws Exception {
        Token t = nextToken();
        if (t != null) {
            Logger.get().logDebug("Lexer", "Returning token " + SymbolsHelper.sym2Sting(t.get()));
            return new Symbol(t.get(), t.getString());
        }
        Logger.get().logDebug("Lexer", "Returning token" + SymbolsHelper.sym2Sting(Symbols.EOF));
        return new Symbol(Symbols.EOF);
    }

    protected Token nextToken() {
        Token t = null;

        while (t == null) {
            char c = ' ';
            int i = 0;
            try {
                i = br.read();
                if (i < 0) {
                    //EOF
                    t = makeToken(strip);
                    strip = "";
                    return t;
                }
                c = (char) i;
            } catch (Exception e) {
                System.out.println("WTF???? i:" + i + " c:" + c + " e:" + e);
                //Corte de emergencia
                t = makeToken(strip);
                strip = "";
                return t;
            }

            State ns = state.next(c);
            if (ns != null) { // si tengo transicion, todo va bien
                strip += c;
                state = ns;
            } else {// si no tengo prox estado es final (valido/ERROR)
                t = makeToken(strip);
                //corregir strip pa que salga andando
                // el char actual es el que no valida con el estado acutal
                // forma parte del proximo token
                strip = String.valueOf(c);
                state = s0.next(c);
                if (state == null) {
                    Logger.get().logOutput("ERROR: Unrecognised token \'" + c + "\'");
                    strip = "";
                    state = s0;
                }else if(state==comment||state==blanks){
                    //limpiamos buffer para ahorrar memoria
                    strip = "";
                }
            }
            // corregir index
            if (String.valueOf(c).matches("(\\r\\n|\\n)")) {
                l++;
                index = 1;
            } else {
                index++;
            }
        }
        return t;
    }

    public int getCurrentLine() {
        return l;
    }

    private Token makeToken(String strip) {
        Token t = state.getToken(strip);
        if (t != null) {
            String s = null;
            int i = -1;
            if (t.get() == Symbols.IDENTIFIER) {
                s = t.getString();
                i= index - s.length();
            } else if (t.get() == Symbols.CONSTANT) {
                s = "CONSTANT_" + t.getString();
                i=index - t.getString().length();
            }
            if (s != null) {
                if (ts.containsKey(s)) {
                    ts.get(s).addOccurrence(l, i);
                } else {
                    SymbolData sd = new SymbolData();
                    sd.addOccurrence(l, i);
                    ts.put(s, sd);
                }
            }
            tokenStrip.add(t);
        }
        return t;
    }

    public void printTS(){
        System.out.println("TABLA DE SIMBOLOS");
        for(String s: ts.keySet()){
            System.out.println("    "+s+" "+ts.get(s).toString());
        }
    }
}

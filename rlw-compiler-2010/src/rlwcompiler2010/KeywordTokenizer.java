/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rlwcompiler2010;

import java.util.HashMap;
import org.xml.sax.ext.LexicalHandler;

/**
 *
 * @author cristian
 */
public class KeywordTokenizer extends AVTokenizer {

    private enum Keywords {

        IF, ELSE, PRINT, FLOAT, INT, FOR
    }
    private HashMap<String, Keywords> dicc = new HashMap<String, Keywords>();

    public Token build(String s) {
//      s = s.toLowerCase();
//	sin lower, si pone whILe ajoderse
        if (dicc.containsKey(s)) {
            return new Token(s, Token.Tokens.KEYWORD);
        }
        //  else
        //       notify("ERROR: Keyword No reconocida: <" + s + ">.");
        return null;
    }

    public KeywordTokenizer(Rlwlex lex) {
        super(lex);
        dicc.put("if", Keywords.IF);
        dicc.put("else", Keywords.ELSE);
        dicc.put("print", Keywords.PRINT);
        dicc.put("float", Keywords.FLOAT);
        dicc.put("int", Keywords.INT);
        dicc.put("for", Keywords.FOR);
    }
}

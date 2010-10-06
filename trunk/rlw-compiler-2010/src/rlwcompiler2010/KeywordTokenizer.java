/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rlwcompiler2010;

import java.util.HashMap;
/**
 *
 * @author cristian
 */
public class KeywordTokenizer extends AVTokenizer {

    private HashMap<String, Integer> dicc = new HashMap<String, Integer>();

    public Token build(String s) {
        //CASE SENSITIVE
        if (dicc.containsKey(s)) {
            return new Token(s, dicc.get(s));
        }
        return null;
    }

    public KeywordTokenizer(Rlwlexer lex) {
        super(lex);
        dicc.put("if", Symbols.IF);
        dicc.put("else", Symbols.ELSE);
        dicc.put("print", Symbols.PRINT);
        dicc.put("float", Symbols.TYPE);
        dicc.put("int", Symbols.TYPE);
        dicc.put("for", Symbols.FOR);
    }
}

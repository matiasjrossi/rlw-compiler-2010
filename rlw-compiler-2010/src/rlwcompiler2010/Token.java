/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rlwcompiler2010;

/**
 *
 * @author cristian
 */
public class Token {

    private int token;
    private String symbol;

    public boolean matches(String s) {
        return symbol.equals(s);
    }

    public int get() {
        return token;
    }
    
    public String getString() {
        return symbol;
    }

    public Token(String s,int t) {
        symbol = s.trim();
        token = t;
    }
}

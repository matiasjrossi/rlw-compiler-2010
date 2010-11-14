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
    private String lexeme;
    private String type;

    public boolean matches(String s) {
        return lexeme.equals(s);
    }

    public int get() {
        return token;
    }
    
    public String getLexeme() {
        return lexeme;
    }

    public Token(String s,int t) {
        lexeme = s.trim();
        token = t;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}

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
public class Token {

    public enum Tokens {
        ID,CONST_INT,CONST_REAL,KEYWORD,OP_ARITM,OP_REL,OP_LOG,COMMENT,
        SEMICOLON,COLON,O_PARENT,C_PARENT,O_BRACKET,C_BRACKET,
        O_ANG_BRACKET,C_ANG_BRACKET
    }

    private Tokens token;
    private String symbol;
    private HashMap<Tokens, String> dicc = new HashMap<Tokens, String>();

    public String get() {
        return dicc.get(token);
    }
    
    public String getString() {
        return symbol;
    }

    public Token(String s, Tokens t) {
        symbol = s;
        token = t;
        dicc.put(Tokens.ID, "ID");
        dicc.put(Tokens.CONST_INT, "CONST_INT");
        dicc.put(Tokens.CONST_REAL, "CONST_REAL");
        dicc.put(Tokens.KEYWORD, "KEYWORD");
        dicc.put(Tokens.OP_ARITM, "OP_ARITM");
        dicc.put(Tokens.OP_REL, "OP_REL");
        dicc.put(Tokens.OP_LOG, "OP_LOG");
        dicc.put(Tokens.COMMENT, "COMMENT");
        dicc.put(Tokens.SEMICOLON, "SEMICOLON");
        dicc.put(Tokens.COLON, "COLON");
        dicc.put(Tokens.O_PARENT, "O_PARENT");
        dicc.put(Tokens.C_PARENT, "C_PARENT");
        dicc.put(Tokens.O_BRACKET, "O_BRACKET");
        dicc.put(Tokens.C_BRACKET, "C_BRACKET");
        dicc.put(Tokens.O_ANG_BRACKET, "O_ANG_BRACKET");
        dicc.put(Tokens.C_ANG_BRACKET, "C_ANG_BRACKET");
    }
}

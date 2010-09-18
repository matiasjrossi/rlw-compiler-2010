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
        ID,CONST_INT,CONST_REAL,KEYWORD,
        SUM,SUB,MULT,DIV, //Arithmetic Operators
        GT_EQUAL,LT_EQUAL,GT,LT, EQUAL, DISTINCT, //RelationShip Operators
        COMMENT,SEMICOLON,COLON,O_PARENT,C_PARENT,O_BRACKET,C_BRACKET,
        ASIGN,TEXT}

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
        symbol = s.trim();
        token = t;
        dicc.put(Tokens.ID, "ID");
        dicc.put(Tokens.CONST_INT, "CONST_INT");
        dicc.put(Tokens.CONST_REAL, "CONST_REAL");
        dicc.put(Tokens.KEYWORD, "KEYWORD");

        dicc.put(Tokens.SUM, "SUM");
        dicc.put(Tokens.SUB, "SUB");
        dicc.put(Tokens.MULT, "MULT");
        dicc.put(Tokens.DIV, "DIV");

        dicc.put(Tokens.GT_EQUAL, "GT_EQUAL");
        dicc.put(Tokens.LT_EQUAL, "LT_EQUAL");
        dicc.put(Tokens.GT, "GT");
        dicc.put(Tokens.LT, "LT");
        dicc.put(Tokens.EQUAL, "EQUAL");
        dicc.put(Tokens.DISTINCT, "DISTINCT");

        dicc.put(Tokens.COMMENT, "COMMENT");
        dicc.put(Tokens.SEMICOLON, "SEMICOLON");
        dicc.put(Tokens.COLON, "COLON");
        dicc.put(Tokens.O_PARENT, "O_PARENT");
        dicc.put(Tokens.C_PARENT, "C_PARENT");
        dicc.put(Tokens.O_BRACKET, "O_BRACKET");
        dicc.put(Tokens.C_BRACKET, "C_BRACKET");

        dicc.put(Tokens.ASIGN, "ASIGN");
        dicc.put(Tokens.TEXT, "TEXT");
    }
}

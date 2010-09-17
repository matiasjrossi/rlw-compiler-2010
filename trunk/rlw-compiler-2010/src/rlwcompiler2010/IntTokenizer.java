/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rlwcompiler2010;

/**
 *
 * @author cristian
 */

public class IntTokenizer extends AVTokenizer {

    public Token build(String s) {
        try {
            Integer i = new Integer(s);
            //Check Bounds - 2^15 < x < 2^15 - 1
            if ( Integer.MIN_VALUE < i &&  i < Integer.MAX_VALUE )
                return new Token(s, Token.Tokens.CONST_INT);
            else
                notify("ERROR: Valor fuera de rango para Constante Entera: <" + s + ">.");
        } catch (Exception e) {
            notify("ERROR: " + e);
        }
        return null;
    }

    public IntTokenizer(Rlwlex lex)
    {
        super(lex);
    }

    

}

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

    public static final int MAX_VALUE = (int) Math.pow(2, 15) - 1;
    public static final int MIN_VALUE = (int) -Math.pow(2, 15);

    public Token build(String ss) {
        String s = ss.trim();
        try {
            Integer i = new Integer(s);
            //Check Bounds - 2^15 < x < 2^15 - 1
            if (MIN_VALUE < i && i < MAX_VALUE) {
                return new Token(s, Symbols.CONSTANT);
            }
        } catch (Exception e) {
        }
        if (!s.isEmpty()) {
            notify("ERROR: Valor fuera de rango para Constante Entera: <" + s + ">.");
        }
        return null;
    }

    public IntTokenizer(Rlwlex lex) {
        super(lex);
    }
}

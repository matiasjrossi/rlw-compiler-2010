/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rlwcompiler2010;

/**
 *
 * @author je
 */
class FloatTokenizer extends AVTokenizer {

    public static final float MAX_VALUE = (float) (1.17549435E38);
    public static final float MIN_VALUE = (float) (3.40282347E-38);

    public FloatTokenizer(Rlwlex lex) {
        super(lex);
    }

    public Token build(String ss) {
        String s = ss.replace(" ", "");
        String regex = "^([0-9]+\\.*[0-9]*|\\.[0-9]+)(E-?[0-9]+)*";
        try {
            if (s.matches(regex)) {
                Float Num = new Float(s);
                if (MIN_VALUE < Num && Num < MAX_VALUE) {
                    return new Token(ss, Token.Tokens.CONST_REAL);
                }                    
            }
        } catch (Exception e) { }

        notify("ERROR: Valor fuera de rango para Constante Real: <"+ ss + ">.");
        return null;
    }
}

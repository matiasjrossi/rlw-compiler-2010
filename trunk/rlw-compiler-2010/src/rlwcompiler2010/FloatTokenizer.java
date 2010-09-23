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

    public FloatTokenizer(Rlwlexer lex) {
        super(lex);
    }

    public Token build(String ss) {
        String s = ss.replaceAll("[ \\t]", "");
        String regex = "^([0-9]+\\.*[0-9]*|\\.[0-9]+)(E-?[0-9]+)*";
        try {
            if (s.matches(regex)) {
                Float Num = new Float(s);
                if (MIN_VALUE < Num && Num < MAX_VALUE) {
                    return new Token(ss, Symbols.CONSTANT);
                }                    
            }
        } catch (Exception e) { }

        if (!s.isEmpty())
            notify("ERROR: Out-of-range value for float constant: \'"+ ss + "\'.");
        if (!s.equals("."))
            notify("ERROR: Unrecognised sequence (might be a float constant?)");
        return null;
    }
}

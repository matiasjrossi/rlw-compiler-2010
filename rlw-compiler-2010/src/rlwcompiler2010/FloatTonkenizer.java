/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rlwcompiler2010;

/**
 *
 * @author je
 */
class FloatTonkenizer extends AVTokenizer{

    public static final float  MAX_VALUE = (float) (1.17549435*Math.pow(10, 38));
    public static final float  MIN_VALUE = (float) (3.40282347*Math.pow(10, -38));

    public FloatTonkenizer(Rlwlex lex) {
        super(lex);
    }

    public Token build(String s) {
        String regex="^([0-9]+[^.]|\\.[0-9]+|[0-9]+\\.+[0-9]+)\\s*(E-?[0-9]+)*";
        String a="22 E-3";
        String[] asd= a.split("E");
        try {
            Float base= new Float(asd[0].trim());;
            Integer exp = new Integer(0);
            if (asd.length == 2) {
               exp = new Integer(asd[1].trim());
            }
            Float Num = new Float(Math.abs(base * (float)Math.pow(10, exp)));
            if ( MIN_VALUE < Num &&  Num < MAX_VALUE )
                return new Token(s, Token.Tokens.CONST_REAL);
        } catch(Exception e) {}
        
        notify("ERROR: Valor fuera de rango para Constante Real: <" + s + ">.");
        return null;
    }

}

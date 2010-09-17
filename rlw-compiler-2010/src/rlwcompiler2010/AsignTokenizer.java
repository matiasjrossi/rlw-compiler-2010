/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rlwcompiler2010;

/**
 *
 * @author je
 */
class AsignTokenizer extends AVTokenizer{

    public AsignTokenizer(Rlwlex lex) {
        super(lex);
    }

    public Token build(String s) {
        //ESTO ESTA MAL!!!
        // REMPLAZAR LAS STRINGS (que es lo que tiene que reconocer)
        // CON LA EXPRESION REGULAR QUE LA RECONOCE!!!!!!!!!
         if (s.matches(":-"))
            return new Token(s, Token.Tokens.ASIGN);
         return null;

    }

}

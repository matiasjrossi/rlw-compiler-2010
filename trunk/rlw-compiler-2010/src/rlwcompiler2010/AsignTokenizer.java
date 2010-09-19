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
         if (s.matches(":-"))
            return new Token(s, Symbols.ASSIGNMENTSYMBOL);
         return null;

    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rlwcompiler2010;

/**
 *
 * @author cristian
 */
class StringTokenizer extends AVTokenizer{

    public StringTokenizer(Rlwlex les) {
        super(les);
    }

    public Token build(String s) {
     return new Token(s,Token.Tokens.TEXT);
        //   throw new UnsupportedOperationException("Not supported yet.");
    }

}

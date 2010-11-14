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

    public StringTokenizer(Rlwlexer les) {
        super(les);
    }

    public Token build(String s) {
     Token t = new Token(s,Symbols.CONSTANT);
     t.setType("string");
     return t;
        //   throw new UnsupportedOperationException("Not supported yet.");
    }

}

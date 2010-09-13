/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rlwcompiler2010;

/**
 *
 * @author cristian
 */
public class OperationTokenizer extends AVTokenizer {

    public OperationTokenizer(Rlwlex lex) {
        super(lex);
    }

    public Token build(String s) {
        if (s.matches("+"))
            return new Token(s, Token.Tokens.OP_ARITM)
    }

}

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
        if (s.matches("\\+")) {
            return new Token(s, Token.Tokens.SUM);
        } else if (s.matches("-")) {
            return new Token(s, Token.Tokens.SUB);
        } else if (s.matches("\\*")) {
            return new Token(s, Token.Tokens.MULT);
        } else if (s.matches("/")) {
            return new Token(s, Token.Tokens.DIV);
        } else if (s.matches("\\>=")) {
            return new Token(s, Token.Tokens.GT_EQUAL);
        } else if (s.matches("\\<=")) {
            return new Token(s, Token.Tokens.LT_EQUAL);
        } else if (s.matches("\\>")) {
            return new Token(s, Token.Tokens.GT);
        } else if (s.matches("\\<")) {
            return new Token(s, Token.Tokens.LT);
        } else if (s.matches("=")) {
            return new Token(s, Token.Tokens.EQUAL);
        } else if (s.matches("\\<\\>")) {
            return new Token(s, Token.Tokens.DISTINCT);
        }
        return null;
    }
}

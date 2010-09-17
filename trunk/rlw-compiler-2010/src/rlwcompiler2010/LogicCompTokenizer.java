/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rlwcompiler2010;

/**
 *
 * @author je
 */
class LogicCompTokenizer extends AVTokenizer {

    public LogicCompTokenizer(Rlwlex lex) {
         super(lex);
    }
    
    public Token build(String s) {
        if (s.matches("\\<"))
            return new Token(s, Token.Tokens.LT);
        else if (s.matches("\\>"))
            return new Token(s, Token.Tokens.GT);
        else if (s.matches("="))
            return new Token(s, Token.Tokens.EQUAL);
        else if (s.matches("\\>="))
            return new Token(s, Token.Tokens.GT_EQUAL);
        else if (s.matches("\\<\\>"))
            return new Token(s, Token.Tokens.DISTINCT);
        else if (s.matches("\\<="))
            return new Token(s, Token.Tokens.LT_EQUAL);
        return null;
    }
}

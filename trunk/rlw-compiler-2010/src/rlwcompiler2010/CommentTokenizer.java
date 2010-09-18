/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rlwcompiler2010;

/**
 *
 * @author cristian
 */
public class CommentTokenizer extends AVTokenizer{

    public CommentTokenizer(Rlwlex lex) {
        super(lex);
    }

    
    public Token build(String s) {
        if(s.matches("//.*"))//?(\\r\\n?|\\n)
            return new Token(s, Token.Tokens.COMMENT);
        return null;
    }

}

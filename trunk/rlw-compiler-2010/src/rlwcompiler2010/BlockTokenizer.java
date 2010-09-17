/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rlwcompiler2010;

/**
 *
 * @author cristian
 */
public class BlockTokenizer extends AVTokenizer{

    public BlockTokenizer(Rlwlex lex) {
        super(lex);
    }

    public Token build(String s) {
        if (s.matches("\\{"))
            return new Token(s, Token.Tokens.O_BRACKET);
        else if (s.matches("\\}"))
            return new Token(s, Token.Tokens.C_BRACKET);
        else if (s.matches("\\("))
            return new Token(s, Token.Tokens.O_PARENT);
        else if (s.matches("\\)"))
            return new Token(s, Token.Tokens.C_PARENT);
        else if (s.matches(","))
            return new Token(s, Token.Tokens.COLON);
        else if (s.matches(";"))
            return new Token(s, Token.Tokens.SEMICOLON);
        return null;
    }

}

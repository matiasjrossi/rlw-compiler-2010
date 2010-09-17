/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rlwcompiler2010;

/**
 *
 * @author je
 */
class SingleTokenizer extends AVTokenizer {

    public SingleTokenizer(Rlwlex lex) {
        super(lex);
    }

    public Token build(String s) {
        //ESTO ESTA MAL!!!
        // REMPLAZAR LAS STRINGS (que es lo que tiene que reconocer)
        // CON LA EXPRESION REGULAR QUE LA RECONOCE!!!!!!!!!
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
        else if (s.matches("\\*"))
            return new Token(s, Token.Tokens.MULT);
        else if (s.matches("\\+"))
            return new Token(s, Token.Tokens.SUM);
        else if (s.matches("-"))
            return new Token(s, Token.Tokens.SUB);
        return null;
    }
    

}

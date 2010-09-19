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
        if (s.matches("\\{"))
            return new Token(s, Symbols.LCURLY);
        else if (s.matches("\\}"))
            return new Token(s, Symbols.RCURLY);
        else if (s.matches("\\("))
            return new Token(s, Symbols.LBRACKET);
        else if (s.matches("\\)"))
            return new Token(s, Symbols.RBRACKET);
        else if (s.matches(","))
            return new Token(s, Symbols.COMMA);
        else if (s.matches(";"))
            return new Token(s, Symbols.SEMICOLON);
        else if (s.matches("\\*"))
            return new Token(s, Symbols.TIMES);
        else if (s.matches("\\+"))
            return new Token(s, Symbols.PLUS);
        else if (s.matches("-"))
            return new Token(s, Symbols.MINUS);
        return null;
    }
    

}

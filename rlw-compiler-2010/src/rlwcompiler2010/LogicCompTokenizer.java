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

        String regex = "(\\<|\\>|=|\\>=|\\<=|\\<\\>)";

        if (s.matches(regex))
            return new Token(s, Symbols.COMPARATOR);
        return null;
    }
}

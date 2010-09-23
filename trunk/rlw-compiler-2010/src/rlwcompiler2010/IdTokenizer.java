/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rlwcompiler2010;

import java.util.regex.*;

/**
 *
 * @author cristian
 */
public class IdTokenizer extends AVTokenizer {

    public Token build(String s) {
        //Check for charcter start and lenght
        String regex = "^[a-zA-Z][a-zA-Z0-9]*";
        if (s.matches(regex)) {
            if (!s.isEmpty() && s.length() < 15) {
                return new Token(s, Symbols.IDENTIFIER);
            } else {
                String sub = s.substring(0, 15);
                notify("WARNING: Identifiers must be shorter than 15 characters: " +
                        "\'" + s + "\'.\n         Trimming to: \'" + sub +"\'.");
                return new Token(sub, Symbols.IDENTIFIER);
            }            
        } else {
            notify("ERROR: Identifiers are not allowed to start with \'" + s + "\'");
        }
        return null;
    }

    public IdTokenizer(Rlwlexer lex)
    {
        super(lex);
    }

}

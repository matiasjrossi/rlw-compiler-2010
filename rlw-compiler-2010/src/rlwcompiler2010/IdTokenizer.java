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
                return new Token(s, Token.Tokens.ID);
            } else {
                String sub = s.substring(0, 15);
                notify("WARNING: Longuitud no permitida de identificador: " +
                        "<" + s + ">. Se acorta como: <" + sub +">.");
                return new Token(sub, Token.Tokens.ID);
            }            
        } else {
            notify("ERROR: Identificador comienza con caracter : <" + s + ">.");
        }
        return null;
    }

    public IdTokenizer(Rlwlex lex)
    {
        super(lex);
    }

}

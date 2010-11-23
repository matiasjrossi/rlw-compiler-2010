/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rlwcompiler2010;

import java.util.Hashtable;
import java_cup.Lexer;

/**
 *
 * @author cristian
 */
public class State {

    private Hashtable<String, State> trans; // String -> chararctr pattern
    private ITokenizer tokenizer;

    public State(ITokenizer i) {
        trans = new Hashtable<String, State>();
        tokenizer = i;
    }

    public Token getToken(String s) {
        //get a string and gen a token
        //imprime errores de construccion del put token
        if (tokenizer == null) {
            return null;
        }
        return tokenizer.build(s);
    }

    public void addTrans(String regex, State e) {
        trans.put(regex, e);
    }

    public State next(char c) {
        String input = String.valueOf(c);
        for (String s : trans.keySet()) {
            if (input.matches(s)) {
                if (String.valueOf(c).matches("(\\r\\n|\\n)")) {
                    Rlwlexer.getLexer().newLine();
                } else {
                    Rlwlexer.getLexer().incIndex();
                }

                return trans.get(s);
            }
        }
        return null;
    }
}

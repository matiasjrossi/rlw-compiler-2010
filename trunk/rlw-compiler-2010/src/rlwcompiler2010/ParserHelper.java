/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rlwcompiler2010;

import java.util.Hashtable;

/**
 *
 * @author matias
 */
public class ParserHelper {

    private Hashtable<String, Token> ts;

    

    /*
     * Singleton
     *
     */

    private ParserHelper(Hashtable<String, Token> ts) {
        this.ts = ts;

    }

    static ParserHelper instance = null;

    static ParserHelper get() {
        return instance;
    }

    static void init(Hashtable<String, Token> ts) {
        instance = new ParserHelper(ts);
    }

}

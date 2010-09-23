/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rlwcompiler2010;

/**
 *
 * @author cristian
 */
public abstract class AVTokenizer implements ITokenizer {
// Annoying Verbosic Tokenizer!
    private Rlwlexer lex;
    public AVTokenizer(Rlwlexer lex){
        this.lex=lex;
    }
    protected void notify(String s){
        Logger.get().logOutput(s);
    }
}

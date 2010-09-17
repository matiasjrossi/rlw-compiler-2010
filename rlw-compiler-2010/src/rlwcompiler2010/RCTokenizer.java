/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rlwcompiler2010;

import java.util.Iterator;
import java.util.Vector;

/**
 *
 * @author je
 */
class RCTokenizer implements ITokenizer{

    private Vector<ITokenizer> tokenizers;
    public RCTokenizer() {
        this.tokenizers=new Vector<ITokenizer>();

    }

    public void add(ITokenizer it){
        tokenizers.add(it);
    }

    public Token build(String s) {
        Token t = null;
        Iterator<ITokenizer> it = tokenizers.iterator();
        while(t==null&&it.hasNext()){
            t=it.next().build(s);
        }
        return t;
    }

}

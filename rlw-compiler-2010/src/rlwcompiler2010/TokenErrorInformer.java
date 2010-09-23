/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rlwcompiler2010;

/**
 *
 * @author je
 */
public class TokenErrorInformer extends AVTokenizer{
    private String message = "UNSPECIFIED ERROR";
    public TokenErrorInformer(Rlwlexer les,String m){
        super(les);
        if(m!=null)
            message=m;
    }
    public Token build(String s) {
        notify(message+" \'"+s+"\'");
        return null;
    }

}

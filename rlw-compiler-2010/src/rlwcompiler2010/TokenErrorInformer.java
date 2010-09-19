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
    private String mensaje = "ERROR NO ESPECIFICADO";
    public TokenErrorInformer(Rlwlex les,String m){
        super(les);
        if(m!=null)
            mensaje=m;
    }
    public Token build(String s) {
        notify(mensaje+" <"+s+">");
        return null;
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rlwcompiler2010;

/**
 *
 * @author matias
 */
public class PolishItem {

    public String label;

    public int cod;

    public boolean flag = false;

    public PolishItem(int cod) {
        this.cod = cod;
    }
    @Override
    public String toString(){
        return label;
    }



}

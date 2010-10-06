/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rlwcompiler2010;

import java.util.Vector;

/**
 *
 * @author je
 */
class SymbolData {
    class Pos{
        private int i,l;
        Pos(int l,int i){
            this.l=l;
            this.i=i;
        }
        int getLine(){return l;}
        int getLinePos(){return i;}
    }
    SymbolData(){
        occurrence=new Vector<Pos>();
    }
    private Vector<Pos> occurrence;
    void addOccurrence(int l, int index){
        occurrence.add(new Pos(l,index));
    }

}

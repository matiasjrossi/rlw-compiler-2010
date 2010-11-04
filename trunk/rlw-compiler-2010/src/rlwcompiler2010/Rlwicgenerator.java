/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rlwcompiler2010;

import java.util.Hashtable;
import java.util.Stack;
import java.util.Vector;

/**
 *
 * @author g
 */
public class Rlwicgenerator {
    private static Rlwicgenerator instance = null;

    public static Rlwicgenerator get(){
        if(instance==null)
             throw new RuntimeException("ICgenerator has not been initialized");
        return instance;
    }

    public static void init(Hashtable<String, SymbolData> ts){
        instance = new Rlwicgenerator(ts);
    }

    private Hashtable<String, SymbolData> ts;
    private Vector<Icelement> ic;
    private Vector<Integer> voids;
    private Rlwicgenerator(Hashtable<String, SymbolData> ts) {
        this.ts = ts;
        this.ic = new Stack<Icelement>();
        this.voids = new Stack<Integer>();
    }

    public void add(Object s){
        ic.add(new Icelement(s));
    }

    public void add(int i,Object s){
        ic.get(i).set(ic.size());
    }

    public void addVoid(){
        voids.add(0,ic.size());
        ic.add(new Icelement());
    }

    public int fillVoid(){
        if(voids.isEmpty())
             throw new RuntimeException("No voids to fill");
        return voids.remove(0);
    }

    public Vector<Icelement> getIC(){
        return ic;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rlwcompiler2010;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
import java.util.Vector;

/**
 *
 * @author matias
 */
public class SymbolsTable {
    
    private Hashtable<String, SymbolData> data;

    private Vector<String> adapter;

    public String getById(int i) {
        return adapter.elementAt(i);
    }

    /*
     * Singleton
     */

    private static SymbolsTable theOne = null;

    private SymbolsTable() {
        data = new Hashtable<String, SymbolData>();
        adapter = new Vector<String>();
    }

    public static SymbolsTable get() {
        if (theOne == null)
            theOne = new SymbolsTable();
        return theOne;
    }

    @Override
    public String toString(){
        String output = "Tabla de Símbolos:\n";
        for(String s: adapter){
            output += data.get(s).getId().toString() + "  ";
            output += data.get(s).printType();
            output += ": " + s;
            if (data.get(s).isConstant()) output += "             CONSTANT ";
            output += '\n';
        }
        return output;
    }

    void put(String identifier, SymbolData symbolData) {
        symbolData.setId(adapter.size());
        data.put(identifier, symbolData);
        adapter.add(identifier);
    }

    SymbolData get(String identifier) {
        return data.get(identifier);
    }

    public boolean containsKey(String s){
        return data.containsKey(s);
    }

    public Set<String> keySet() {
        return new HashSet<String>(data.keySet());
    }
}

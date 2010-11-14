/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rlwcompiler2010;

import java.util.Vector;

/**
 *
 * @author matias
 */
public class ReversePolishNotation {

    private ReversePolishNotation() {
        operations.add("ADD");
        operations.add("MUL");
        operations.add("DIV");
        operations.add("SUB");
        operations.add("ASS");
        operations.add("PRN");
    }


    private static ReversePolishNotation theOne = null;

    public static ReversePolishNotation get() {
        if (theOne == null)
            theOne = new ReversePolishNotation();
        return theOne;
    }

    /////END OF SINGLETON

    private Vector<Integer> strip = new Vector<Integer>();
    private Vector<String> operations = new Vector<String>();

    public void addOp(String op) {
        strip.add(opCode(op));
    }

    public int opCode(String op) {
        return operations.indexOf(op);
    }

    public String operation(int i) {
        return operations.elementAt(i);
    }
    
    public static final int offset = 1000;

    @Override
    public String toString() {

        String output = "\n\nPolaca Inversa:\n";

        for (Integer i: strip) {
            output += (i<offset?operation(i):i-offset) + "; ";
        }

        return output;
        
    }

    void addSym(Integer id) {
        strip.add(id + offset);
    }
}

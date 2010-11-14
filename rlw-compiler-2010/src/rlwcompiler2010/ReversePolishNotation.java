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
        fillOperations();
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

    public Vector<Integer> getStrip(){
        return strip;
    }

    private void fillOperations() {
        //Arithmetic binary operators: Take two from stack, put the result in the stack
        operations.add("ADD");
        operations.add("MUL");
        operations.add("DIV");
        operations.add("SUB");
        //Comparators: Take the top from stack and compare it to the new top (after taking it out). Then push '0' if false or any other value if true.
        operations.add("EQ");
        operations.add("DIS");
        operations.add("LT");
        operations.add("GT");
        operations.add("LE");
        operations.add("GE");

        operations.add("ASS"); //Two "unary steps" operator: Takes the destination address from stack, then takes the value from stack.
        operations.add("PRN"); //Unary operator: Takes top of the stack

        operations.add("JMP"); //
        operations.add("JIF");

    }

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
            output += (i<offset?operation(i):SymbolsTable.get().getById(i-offset)) + "; ";
        }

        return output;
        
    }

    void addSym(Integer id) {
        strip.add(id + offset);
    }
}

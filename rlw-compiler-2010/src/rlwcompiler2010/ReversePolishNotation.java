/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rlwcompiler2010;

import java.util.LinkedList;
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

    private LinkedList<PolishItem> strip = new LinkedList<PolishItem>();
    private Vector<String> operations = new Vector<String>();

    public LinkedList<PolishItem> getStrip(){
        return strip;
    }

    private void fillOperations() {
        //Arithmetic binary operators: Take two from stack, put the result in the stack
        operations.add("ADD");
        operations.add("MUL");
        operations.add("DIV");
        operations.add("SUB");
        //Comparators: Take the top from stack and compare it to the new top (after taking it out). Then push '0' if false or any other value if true.
        operations.add("CMP");
        operations.add("JEQ");
        operations.add("JNE");
        operations.add("JLT");
        operations.add("JGT");
        operations.add("JLE");
        operations.add("JGE");

        operations.add("ASS"); //Two "unary steps" operator: Takes the destination address from stack, then takes the value from stack.
        operations.add("PRN"); //Unary operator: Takes top of the stack

        operations.add("JMP");

        operations.add("LBL");

        operations.add("");

    }

    public void addOp(String op) throws Exception {
        if (op.equals("PRN") && SymbolsTable.get().get(SymbolsTable.get().getById(strip.getLast().cod-offset)).getType() != SymbolData.DataType.STRING) {
            Logger.get().logOutput("Cannot print non-string symbol");
            throw new Exception();
        }
        strip.add(new PolishItem(opCode(op)));
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

        for (PolishItem pi: strip) {
           if (pi.flag)
                output += pi.label + ": ; ";
            else
                output += (pi.cod<offset?operation(pi.cod):SymbolsTable.get().getById(pi.cod-offset)) + "; ";
        }

        return output;
        
    }

    void addSym(Integer id) {
        strip.add(new PolishItem(id + offset));
    }

    void addLabel(String string) {
        PolishItem pi = new PolishItem(-1);
        pi.flag = true;
        pi.label = string;
        strip.add(pi);
    }

    void labelCode(String label) {
        addLabel(label);
        try {
            addOp("LBL");
        } catch (Exception ex) {
        }
    }
}

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
public class ParserHelper {

    private int currentScope = 0;

    private int depth = 0;

    private Vector<String> idBuf;

    private boolean failed = false;

    private ParserHelper() {
        idBuf = new Vector<String>();
    }

    private static ParserHelper instance = null;

    public static ParserHelper get() {
        if (instance == null)
            instance = new ParserHelper();
        return instance;
    }

    public void curlyOpened() {
        currentScope++;
        depth++;
    }

    public void multiStatementBlockClosed() {
        currentScope--;
        depth--;
    }

    public void program() throws SemanticErrorException  {
        if (failed)
            throw new SemanticErrorException();
     //   throw new UnsupportedOperationException("Not yet assembled ='(");
        try{
        System.out.println(Rlwic2asm.get().getASM());
        }catch(Exception e){
            System.out.println("Excepcion catcheada "+e);
            e.printStackTrace();;
        }
    }

    public void declaration(String type) {
        for (String id: idBuf) {
            //Mangling
            SymbolsTable.get().put(mangled(id), new SymbolData());
            //Type
            SymbolsTable.get().get(mangled(id)).setType(type);
        }
        idBuf.clear();
    }

    private String mangled(String id) {
        if (currentScope != 0)
            return global(id + "_" + Integer.toString(currentScope));
        else
            return global(id);
    }

    private String global(String id) {
        return id + "_1";
    }

    public void identifier(String id) {
        idBuf.add(id);
    }

    public void operand(String operand) {
        if ((depth != 0) && (SymbolsTable.get().containsKey(mangled(operand)))) {
            ReversePolishNotation.get().addSym(SymbolsTable.get().get(mangled(operand)).getId());
        } else if (SymbolsTable.get().containsKey(global(operand))) {
            ReversePolishNotation.get().addSym(SymbolsTable.get().get(global(operand)).getId());
        } else if (SymbolsTable.get().containsKey(operand)) {
            ReversePolishNotation.get().addSym(SymbolsTable.get().get(operand).getId());
        } else {
            Logger.get().logOutput("Undeclared variable: \"" + operand + "\"");
            failed = true;
        }
        
    }

    public void operator(String op) {
        try {
              ReversePolishNotation.get().addOp(op);
        } catch (Exception e) {
            failed = true;
        }
    }

    public void unaryMinus(String operand) {
        if (!SymbolsTable.get().containsKey("-" + operand)) {
            if (SymbolsTable.get().containsKey(operand)) {
                if (SymbolsTable.get().get(operand).getType() != SymbolData.DataType.STRING)
                    SymbolsTable.get().put("-" + operand, new SymbolData(SymbolsTable.get().get(operand)));
                else
                {
                    Logger.get().logOutput("Invalid unary minus operation in String constant");
                    failed = true;
                }
            } else {
                throw new UnsupportedOperationException("!!!WRONG CONSTANT?!!!");
            }
        }
        ReversePolishNotation.get().addSym(SymbolsTable.get().get("-"+operand).getId());
    }

    public void assignTo(String operand) {
        if ((depth != 0) && (SymbolsTable.get().containsKey(mangled(operand)))) {
            ReversePolishNotation.get().addSym(SymbolsTable.get().get(mangled(operand)).getId());
        } else if (SymbolsTable.get().containsKey(global(operand))) {
            ReversePolishNotation.get().addSym(SymbolsTable.get().get(global(operand)).getId());
        } else {
            Logger.get().logOutput("Unknown symbol for LVALUE: \"" + operand + "\"");
            failed = true;
        }
        operator("ASS");
    }

    public void comparator(String op) {
        try {
            if (op.equals("=")) ReversePolishNotation.get().addOp("EQ");
            else if (op.equals("<>")) ReversePolishNotation.get().addOp("DIS");
            else if (op.equals("<")) ReversePolishNotation.get().addOp("LT");
            else if (op.equals("<=")) ReversePolishNotation.get().addOp("LE");
            else if (op.equals(">")) ReversePolishNotation.get().addOp("GT");
            else if (op.equals(">=")) ReversePolishNotation.get().addOp("GE");
        } catch (Exception e) {
            failed = true;
        }
    }

    public void iF() {

    }

    public void label() {
        
    }

}

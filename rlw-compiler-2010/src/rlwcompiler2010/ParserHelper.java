/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rlwcompiler2010;

import java.util.Stack;
import java.util.Vector;

/**
 *
 * @author matias
 */
public class ParserHelper {

    private int currentScope = 0;

    private int depth = 0;

    private Stack<String> forCounterStack = new Stack<String>();

    private Stack<String> forIncrementStack = new Stack<String>();

    private Stack<Integer> forStack = new Stack<Integer>();

    private int forN = 0;

    private int ifN = 0;

    private Stack<Integer> ifStack = new Stack<Integer>();

    private Stack<String> cmpStack = new Stack<String>();

    private Vector<String> idBuf;

    public boolean failed = false;

    private ParserHelper() {
        idBuf = new Vector<String>();
    }

    private static ParserHelper instance = null;

    public static ParserHelper get() {
        if (instance == null)
            instance = new ParserHelper();
        return instance;
    }

    public void scopeStart() {
        currentScope++;
        depth++;
    }

    public void scopeEnd() {
        depth--;
    }

    public void program() throws SemanticErrorException  {
        if (failed)
            throw new SemanticErrorException();
        try{
            Rlwic2asm.get().makeASM();
        }catch(Exception e){
            Logger.get().logDebug("ParserHelper", "Exception from ASM generator catched: " + e);
            Logger.get().logDebug("ParserHelper", e.getStackTrace().toString());
        }
    }

    public void declaration(String type) {
        for (String id: idBuf) {
            if (SymbolsTable.get().containsKey(mangled(id))) {
                failed  = true;
                Logger.get().logOutput("ERROR: Symbol '" + id + "' already declared in local scope.");
                break;
            }
            //Mangling
            SymbolsTable.get().put(mangled(id), new SymbolData());
            //Type
            SymbolsTable.get().get(mangled(id)).setType(type);
        }
        idBuf.clear();
    }

    private String mangled(String id) {
        if (depth != 0)
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
        cmpStack.push(op);
        operator("CMP");
    }

    public void then() {
        String cmp = cmpStack.pop();

        ReversePolishNotation.get().addLabel("elseLabel_" + ifStack.peek().toString());

        if (cmp.equals("<")) operator("JGE");
        else if(cmp.equals("<=")) operator("JGT");
        else if(cmp.equals(">")) operator("JLE");
        else if(cmp.equals(">=")) operator("JLT");
        else if(cmp.equals("=")) operator("JNE");
        else if(cmp.equals("<>")) operator("JEQ");
    }

    public void elseLabel() {
        ReversePolishNotation.get().addLabel("endifLabel_" + ifStack.peek().toString());
        try {
            ReversePolishNotation.get().addOp("JMP");
        } catch (Exception e) {
            failed = true;
        }
        ReversePolishNotation.get().labelCode("elseLabel_" + ifStack.peek().toString());
    }

    public void endifLabel() {
        ReversePolishNotation.get().labelCode("endifLabel_" + ifStack.peek().toString());
    }

    public void loopStart(String id, String idexp) {
        forCounterStack.push(id);
        identifier(id);
        declaration("int");
        operand(idexp);
        try {
            if (SymbolsTable.get().get(SymbolsTable.get().getById(ReversePolishNotation.get().getStrip().getLast().cod - ReversePolishNotation.offset)).getType() != SymbolData.DataType.INT) {                Logger.get().logOutput("ERROR: Non-integer initialization argument in FOR construct.");
                Logger.get().logOutput("ERROR: Non-integer initialization argument in FOR construct.");
                failed = true;
            }
        } catch (Exception e) {
            failed = true;
            Logger.get().logDebug("ParserHelper", "Non-symbol in RPN before loopStart(id) call.");
            Logger.get().logDebug("ParserHelper", e.getStackTrace().toString());
        }

        assignTo(id);
    }

    public void loopStart(String id) {
        try {
            if (SymbolsTable.get().get(SymbolsTable.get().getById(ReversePolishNotation.get().getStrip().getLast().cod - ReversePolishNotation.offset)).getType() != SymbolData.DataType.INT) {
                Logger.get().logOutput("ERROR: Non-integer initialization argument in FOR construct.");
                failed = true;
            }
        } catch (Exception e) {
            failed = true;
            Logger.get().logDebug("ParserHelper", "Non-symbol in RPN before loopStart(id) call.");
            Logger.get().logDebug("ParserHelper", e.getStackTrace().toString());
        }

        forCounterStack.push(id);
        identifier(id);
        declaration("int");
        assignTo(id);
    }

    public void loopCheck(String id, String cmp, String idexp) {
        ReversePolishNotation.get().labelCode("loopCheck_" + forStack.peek().toString());
        operand(id);
        if (SymbolsTable.get().get(SymbolsTable.get().getById(ReversePolishNotation.get().getStrip().getLast().cod - ReversePolishNotation.offset)).getType() != SymbolData.DataType.INT) {
            Logger.get().logOutput("ERROR: Non-integer argument in FOR loop condition.");
            failed = true;
        }
        operand(idexp);
        if (SymbolsTable.get().get(SymbolsTable.get().getById(ReversePolishNotation.get().getStrip().getLast().cod - ReversePolishNotation.offset)).getType() != SymbolData.DataType.INT) {
            Logger.get().logOutput("ERROR: Non-integer argument in FOR loop condition.");
            failed = true;
        }
        operator("CMP");
        ReversePolishNotation.get().addLabel("loopEnd_" + forStack.peek().toString());

        if (cmp.equals("<")) operator("JGE");
        else if(cmp.equals("<=")) operator("JGT");
        else if(cmp.equals(">")) operator("JLE");
        else if(cmp.equals(">=")) operator("JLT");
        else if(cmp.equals("=")) operator("JNE");
        else if(cmp.equals("<>")) operator("JEQ");

    }

    public void loopCheck(String id, String cmp) {
        try {
            if (SymbolsTable.get().get(SymbolsTable.get().getById(ReversePolishNotation.get().getStrip().getLast().cod - ReversePolishNotation.offset)).getType() != SymbolData.DataType.INT) {
                Logger.get().logOutput("ERROR: Non-integer initialization argument in FOR construct.");
                failed = true;
            }
        } catch (Exception e) {
            failed = true;
            Logger.get().logDebug("ParserHelper", "Non-symbol in RPN before loopCheck(id,cmp) call.");
            Logger.get().logDebug("ParserHelper", e.getStackTrace().toString());
        }

        ReversePolishNotation.get().labelCode("loopCheck_" + forStack.peek().toString());
        operand(id);
        if (SymbolsTable.get().get(SymbolsTable.get().getById(ReversePolishNotation.get().getStrip().getLast().cod - ReversePolishNotation.offset)).getType() != SymbolData.DataType.INT) {
            Logger.get().logOutput("ERROR: Non-integer argument in FOR loop condition.");
            failed = true;
        }

        operator("CMP");
        ReversePolishNotation.get().addLabel("loopEnd_" + forStack.peek().toString());

        if (cmp.equals("<")) operator("JLE");
        else if(cmp.equals("<=")) operator("JLT");
        else if(cmp.equals(">")) operator("JGE");
        else if(cmp.equals(">=")) operator("JGT");
        else if(cmp.equals("=")) operator("JNE");
        else if(cmp.equals("<>")) operator("JEQ");
    }


    public void loopAfter(String id) {
        forIncrementStack.push(id);
    }


    public void loopAfter() {
        forIncrementStack.push(SymbolsTable.get().getById(ReversePolishNotation.get().getStrip().removeLast().cod-ReversePolishNotation.offset));
    }

    public void iF() {
        ifStack.push(++ifN);
    }

    public void foR() {
        forStack.push(++forN);
    }

    public void endIf() {
        ifStack.pop();
    }

    public void endFor() {
        operand(forCounterStack.peek());
        operand(forIncrementStack.pop());
        if (SymbolsTable.get().get(SymbolsTable.get().getById(ReversePolishNotation.get().getStrip().getLast().cod - ReversePolishNotation.offset)).getType() != SymbolData.DataType.INT) {
            Logger.get().logOutput("ERROR: Non-integer increment in FOR construct.");
            failed = true;
        }

        operator("ADD");
        operand(forCounterStack.pop());
        operator("ASS");

        ReversePolishNotation.get().addLabel("loopCheck_" + forStack.peek().toString());
        operator("JMP");

        ReversePolishNotation.get().labelCode("loopEnd_" + forStack.pop().toString());

    }

}
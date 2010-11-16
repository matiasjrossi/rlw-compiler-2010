/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rlwcompiler2010;

import java.util.Vector;
import rlwcompiler2010.SymbolData.DataType;

/**
 *
 * @author je
 */
public class Rlwic2asm {

    private Rlwic2asm() {
    }
    private static Rlwic2asm theOne = null;
    static public Rlwic2asm get() {
        if (theOne == null) {
            theOne = new Rlwic2asm();
        }
        return theOne;
    }
    private String asm=null;
    public String getASM() throws SemanticErrorException {
        if(asm==null)
            asm=makeASM();
        return asm;
    }

    private String makeASM(){
        String head = ".386\n"
                + ".model flat, stdcall\n"
                + "option casemap :none\n"
                + "include \\masm32\\include\\windows.inc\n"
                + "include \\masm32\\include\\kernel32.inc\n"
                + "include \\masm32\\include\\user32.inc\n"
                + "includelib \\masm32\\lib\\kernel32.lib\n"
                + "includelib \\masm32\\lib\\user32.lib\n";
        String stack =
                ".model small\n"+
                ".stack 100h\n";
        String data = ".data\n"
                + "    fperon ds 4\n"
                + "    sumOverError db 'Error! Overflow en una suma$'\n"
                + "    sumOverError db 'Error! Intento de division por 0$'\n";
        SymbolsTable st = SymbolsTable.get();
        for (String key : st.keySet()) {
            SymbolData sdata = st.get(key);
            if (sdata.isConstant()) {
                data += "    CONSTANT" + sdata.getId()+
                        (sdata.getType()==DataType.STRING?
                        " db '"+key.trim().substring(1,key.length()-1)+"$'"
                            :"dd "+key )+ "\n";
            } else {
                data += "    "+key + " ds 4\n";
            }
        }

        String code = ".code\n"
                + "main:\n"
                + "    mov ax, @data\n"
                + "    mov ds, ax\n";
        ReversePolishNotation rpn = ReversePolishNotation.get();
        Vector<PolishItem> operands = new Vector<PolishItem>();
        Vector<SymbolData.DataType> pushedTypes = new Vector<SymbolData.DataType>();

        for (PolishItem p : rpn.getStrip()) {
            String asm = "";
            if (p.flag) {
                operands.add(p);
            } else if (p.cod >= rpn.offset) {
                //new operand
                operands.add(p);
            } else {
                // new operation
                String op = rpn.operation(p.cod);
                //  System.out.println("nueva "+op+" "+operands);
                if (op.equals("ADD")) {
                    while (!operands.isEmpty()) {
                        String k = SymbolsTable.get().getById(
                                operands.remove(0).cod
                                - ReversePolishNotation.offset);
                        SymbolData src = SymbolsTable.get().get(k);
                        String id = src.isConstant() ? "CONSTANT" + src.getId() : k;

                        asm += "    push " + id + "\n";
                        pushedTypes.add(src.getType());

                    }
                    DataType tb = pushedTypes.remove(0);
                    asm += "    pop ebx\n";
                    DataType ta = pushedTypes.remove(0);
                    asm += "    pop eax\n";
                    if (tb == DataType.FLOAT || ta == DataType.FLOAT) {
                        asm += "    mov fperon,ebx ; suma float\n"
                                + (tb == DataType.FLOAT
                                ? "    fld fperon\n"
                                : "    fild fperon\n")
                                + "    mov fperon,eax\n"
                                + (tb == DataType.FLOAT
                                ? "    fld fperon\n"
                                : "    fild fperon\n")
                                + "    fadd\n"
                                + "    fst fperon\n"
                                + "    mov eax,fperon\n"
                                + "    jo _sumOver\n"
                                + "    push eax\n";
                        pushedTypes.add(DataType.FLOAT);
                    } else {
                        asm += "    iadd eax,ebx ; suma entera\n"
                                + "    jo _sumOver\n"
                                + "    push eax\n";
                        pushedTypes.add(DataType.INT);
                    }

                } else if (op.equals("MUL")) {
                    while (!operands.isEmpty()) {
                        String k = SymbolsTable.get().getById(
                                operands.remove(0).cod
                                - ReversePolishNotation.offset);
                        SymbolData src = SymbolsTable.get().get(k);
                        String id = src.isConstant() ? "CONSTANT" + src.getId() : k;

                        asm += "    push " + id + "\n";
                        pushedTypes.add(src.getType());

                    }
                    DataType tb = pushedTypes.remove(0);
                    asm += "    pop ebx\n";
                    DataType ta = pushedTypes.remove(0);
                    asm += "    pop eax\n";
                    if (tb == DataType.FLOAT || ta == DataType.FLOAT) {
                        asm += "    mov fperon,ebx ; mul float\n"
                                + (tb == DataType.FLOAT
                                ? "    fld fperon\n"
                                : "    fild fperon\n")
                                + "    mov fperon,eax\n"
                                + (tb == DataType.FLOAT
                                ? "    fld fperon\n"
                                : "    fild fperon\n")
                                + "    fmul\n"
                                + "    fst fperon\n"
                                + "    mov eax,fperon\n"
                                + "    push eax\n";
                        pushedTypes.add(DataType.FLOAT);
                    } else {
                        asm += "    imul eax,ebx;mult entera\n"
                               +"    push eax\n";
                        pushedTypes.add(DataType.INT);
                    }
                } else if (op.equals("DIV")) {
                    while (!operands.isEmpty()) {
                        String k = SymbolsTable.get().getById(
                                operands.remove(0).cod
                                - ReversePolishNotation.offset);
                        SymbolData src = SymbolsTable.get().get(k);
                        String id = src.isConstant() ? "CONSTANT" + src.getId() : k;

                        asm += "    push " + id + "\n";
                        pushedTypes.add(src.getType());

                    }
                    DataType tb = pushedTypes.remove(0);
                    asm += "    pop ebx\n"
                            + "    comp ebx,0\n"
                            + "    je _zeroDiv\n";
                    DataType ta = pushedTypes.remove(0);
                    asm += "    pop eax\n";
                    if (tb == DataType.FLOAT || ta == DataType.FLOAT) {
                        asm += "    mov fperon,ebx; div float \n"
                                + (tb == DataType.FLOAT
                                ? "    fld fperon\n"
                                : "    fild fperon\n")
                                + "    mov fperon,eax\n"
                                + (tb == DataType.FLOAT
                                ? "    fld fperon\n"
                                : "    fild fperon\n")
                                + "    fdiv\n"
                                + "    fst fperon\n"
                                + "    mov eax,fperon\n"
                                + "    push eax\n";
                        pushedTypes.add(DataType.FLOAT);
                    } else {
                        asm += "    mov edx,0; div entera\n"
                                + "    idiv ebx\n"
                                + "    push eax\n";
                        pushedTypes.add(DataType.INT);
                    }
                } else if (op.equals("SUB")) {
                    while (!operands.isEmpty()) {
                        String k = SymbolsTable.get().getById(
                                operands.remove(0).cod
                                - ReversePolishNotation.offset);
                        SymbolData src = SymbolsTable.get().get(k);
                        String id = src.isConstant() ? "CONSTANT" + src.getId() : k;

                        asm += "    push " + id + "\n";
                        pushedTypes.add(src.getType());

                    }
                    DataType tb = pushedTypes.remove(0);
                    asm += "    pop ebx\n";
                    DataType ta = pushedTypes.remove(0);
                    asm += "    pop eax\n";
                    if (tb == DataType.FLOAT || ta == DataType.FLOAT) {
                        asm += "    mov fperon,ebx; resta float \n"
                                + (tb == DataType.FLOAT
                                ? "    fld fperon\n"
                                : "    fild fperon\n")
                                + "    mov fperon,eax\n"
                                + (tb == DataType.FLOAT
                                ? "    fld fperon\n"
                                : "    fild fperon\n")
                                + "    fsub\n"
                                + "    fst fperon\n"
                                + "    mov eax,fperon\n"
                                + "    push eax\n";
                        pushedTypes.add(DataType.FLOAT);
                    } else {
                        asm += "    mov fperon,ebx ; resta entera\n"
                                + "    mov edx,0\n"
                                + "    isub eax,ebx\n"
                                + "    push eax\n";
                        pushedTypes.add(DataType.INT);
                    }
                } else if (op.equals("ASS")) {
                    String d1 = null, d2 = null;
                    d1 = st.getById(operands.remove(0).cod - rpn.offset);
                    if (!operands.isEmpty()) {
                        d2 = d1;
                        SymbolData rval = st.get(d2);

                        d1 = st.getById(operands.remove(0).cod - rpn.offset);
                        SymbolData lval = st.get(d1);
                        String id = (rval.isConstant() ? "CONSTANT" + rval.getId() : d2);
                        asm += "    mov eax," + id + "\n";
                        if(lval.getType()== DataType.INT && rval.getType() == DataType.FLOAT ){
                          System.out.println("conversion invalida int<-float");
                          //     throw new SemanticErrorException("Invalid convertion from float to int");
                        }
                        if(lval.getType()== DataType.FLOAT && rval.getType() == DataType.INT ){
                            asm += "    mov fperon,eax; conversion implicit\n"+
                                   "    fild fperon\n"+
                                   "    fst fperon\n"+
                                   "    mov eax,fperon\n";
                        }
                    }else{
                        asm += "    pop eax\n";
                        DataType lt = pushedTypes.remove(0);
                        SymbolData lval = st.get(d1);
                        if(lval.getType()== DataType.INT && lt == DataType.FLOAT ){
                           System.out.println("conversion invalida int<-float");
                          //throw new SemanticErrorException("Invalid convertion from float to int");
                        }
                        if(lval.getType()== DataType.FLOAT && lt == DataType.INT ){
                            asm += "    mov fperon,eax; conversion implicit\n"+
                                   "    fild fperon\n"+
                                   "    fst fperon\n"+
                                   "    mov eax,fperon\n";
                        }
                    }
                    asm += "    mov " + d1 + ",eax\n";

                } else if (op.equals("PRN")){
                    SymbolData rval = st.get(st.getById(operands.remove(0).cod - rpn.offset));
                    asm += "    mov dx,OFFSET CONSTANT"+rval.getId()+"\n"+
                            "    mov ah,9\n"+
                            "    int 21h\n";
                } else if (op.equals("CMP")){
                    while (!operands.isEmpty()) {
                        String k = SymbolsTable.get().getById(
                                operands.remove(0).cod
                                - ReversePolishNotation.offset);
                        SymbolData src = SymbolsTable.get().get(k);
                        String id = src.isConstant() ? "CONSTANT" + src.getId() : k;
                        asm += "    push " + id + "\n";
                        pushedTypes.add(src.getType());
                    }
                    DataType tb = pushedTypes.remove(0);
                    asm += "    pop ebx\n";
                    DataType ta = pushedTypes.remove(0);
                    asm += "    pop eax\n";
                    if(ta == DataType.INT && tb == DataType.INT){
                        asm += "    cmp eax,ebx; comp int\n";
                    }else{
                        asm +="    mov fperon,ebx; comp float \n"
                                + (tb == DataType.FLOAT
                                ? "    fld fperon\n"
                                : "    fild fperon\n")
                                + "    mov fperon,eax\n"
                                + (tb == DataType.FLOAT
                                ? "    fld fperon\n"
                                : "    fild fperon\n")
                                + "    fcompp\n"
                                + "    fstsw fperon\n"
                                + "    fwait\n"
                                + "    mov ax,fperon\n"
                                + "    sahf";
                    }
                } else if (op.equals("LBL")) {
                    asm += "_"+p.label+":\n";
                } else if (op.equals("JEQ")){
                    PolishItem pi = operands.remove(0);
                    asm += "    je _"+pi.label+"\n";
                }else if (op.equals("JNE")) {
                    PolishItem pi = operands.remove(0);
                    asm += "    jne _"+pi.label+"\n";
                } else if (op.equals("JLT")) {
                    PolishItem pi = operands.remove(0);
                    asm += "    jb _"+pi.label+"\n";
                } else if (op.equals("JGT")) {
                    PolishItem pi = operands.remove(0);
                    asm += "    jg _"+pi.label+"\n";
                } else if (op.equals("JLE")) {
                    PolishItem pi = operands.remove(0);
                    asm += "    jbe _"+pi.label+"\n";
                } else if (op.equals("JGE")) {
                    PolishItem pi = operands.remove(0);
                    asm += "    jge _"+pi.label+"\n";
                }
            }
            code += asm;
         //   System.out.print(asm);
        }
        code += "    mov ah,4ch\n"
                + "    mov al,0\n"
                + "    int 21h\n"
                + "end main\n"
                + "zeroDiv:\n"
                + "mov dx,OFFSET zeroDivError\n"
                + "mov ah,9\n"
                + "int 21h\n"
                + "mov ah,4ch\n"
                + "mov al,0\n"
                + "int 21h\n"
                + "end \n"
                + "sumOver:\n"
                + "mov dx,OFFSET sumOverError\n"
                + "mov ah,9\n"
                + "int 21h\n"
                + "mov ah,4ch\n"
                + "mov al,0\n"
                + "int 21h\n"
                + "end \n";

        return stack + data + code;
    }

}

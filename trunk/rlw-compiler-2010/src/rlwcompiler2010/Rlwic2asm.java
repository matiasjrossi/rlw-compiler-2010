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

    public String getASM() {
        String head = ".386\n"
                + ".model flat, stdcall\n"
                + "option casemap :none\n"
                + "include \\masm32\\include\\windows.inc\n"
                + "include \\masm32\\include\\kernel32.inc\n"
                + "include \\masm32\\include\\user32.inc\n"
                + "includelib \\masm32\\lib\\kernel32.lib\n"
                + "includelib \\masm32\\lib\\user32.lib\n";

        String data = ".data\n"
                + "fperon ds 4\n";
        SymbolsTable st = SymbolsTable.get();
        for (String key : st.keySet()) {
            SymbolData sdata = st.get(key);
            if (sdata.isConstant()) {
                data += "CONSTANT" + sdata.getId() + " db " + key + ", 0\n";
            } else {
                data += key + " ds 4\n";
            }
        }

        String code = ".code\n"
                + "main:\n"
                + "    mov ax, @data\n"
                + "    mov ds, ax\n";
        ReversePolishNotation rpn = ReversePolishNotation.get();
        Vector<PolishItem> operands = new Vector<PolishItem>();

        boolean usingCOOP = false;
        for (PolishItem p : rpn.getStrip()) {
            if (p.flag) {
            } else if (p.cod >= rpn.offset) {
                //new operand
                operands.add(0, p);
            } else {
                // new operation
                String asm = "";
                String op = rpn.operation(p.cod);
                if (op.equals("ADD")) {
                    String d1 = null, d2 = null;
                    d1 = st.getById(operands.remove(0).cod - rpn.offset);
                    SymbolData src = st.get(d1),
                            dest = null;
                    String id1 = src.isConstant() ? "CONSTANT" + src.getId() : d1, id2 = null;
                    if (!operands.isEmpty()) {
                        d2 = st.getById(operands.remove(0).cod - rpn.offset);
                        dest = st.get(d2);
                        id2 = (dest.isConstant() ? "CONSTANT" + dest.getId() : d2);
                    }
                    if (d2 == null && usingCOOP) {
                        asm += "  fld " + id1 + "\n"
                                + "  fadd\n";
                    } else if (d2 == null
                            && !usingCOOP
                            && src.getType() == SymbolData.DataType.FLOAT) {
                        asm += "  mov fperon,eax\n"
                                + "  fld fperon\n"
                                + "  fld " + id1 + "\n"
                                + "  fadd\n";
                        usingCOOP = true;
                    } else if (d2 == null
                            && !usingCOOP
                            && src.getType() == SymbolData.DataType.INT) {
                        asm += "  mov ebx," + id1 + "\n"
                                + "  add eax,ebx\n";
                    } else if (d2 != null
                            && dest.getType() == SymbolData.DataType.INT
                            && src.getType() == SymbolData.DataType.INT) {
                        asm += "    mov eax," + id1 + "\n"
                                + "   mov ebx," + id2 + "\n"
                                + "    add eax,abx\n";
                    } else if (d2 != null
                            && (dest.getType() == SymbolData.DataType.FLOAT
                            || src.getType() == SymbolData.DataType.FLOAT)) {
                        asm += "    fld " + id1 + "\n"
                                + "    fld " + id2 + "\n"
                                + "    fadd \n";
                        usingCOOP = true;
                    }
                } else if (op.equals("MUL")) {

                    String d1 = null, d2 = null;
                    d1 = st.getById(operands.remove(0).cod - rpn.offset);
                    SymbolData src = st.get(d1),
                            dest = null;
                    String id1 = src.isConstant() ? "CONSTANT" + src.getId() : d1, id2 = null;
                    if (!operands.isEmpty()) {
                        d2 = st.getById(operands.remove(0).cod - rpn.offset);
                        dest = st.get(d2);
                        id2 = (dest.isConstant() ? "CONSTANT" + dest.getId() : d2);
                    } else if (d2 == null && usingCOOP) {
                        asm += "  fld " + id1 + "\n"
                                + "  fmul\n";
                    } else if (d2 == null
                            && !usingCOOP
                            && src.getType() == SymbolData.DataType.FLOAT) {
                        asm += "  mov fperon,eax\n"
                                + "  fld fperon\n"
                                + "  fld " + id1 + "\n"
                                + "  fmul\n";
                        usingCOOP = true;
                    } else if (d2 == null
                            && !usingCOOP
                            && src.getType() == SymbolData.DataType.INT) {
                        asm += "  mov ebx," + id1 + "\n"
                                + "  imul eax,ebx\n";
                    } else if (d2 != null
                            && dest.getType() == SymbolData.DataType.INT
                            && src.getType() == SymbolData.DataType.INT) {
                        asm += "    mov eax," + id1 + "\n"
                                + "    mov ebx," + id2 + "\n"
                                + "    imul eax,abx\n";
                    } else if (d2 != null
                            && (dest.getType() == SymbolData.DataType.FLOAT
                            || src.getType() == SymbolData.DataType.FLOAT)) {
                        asm += "    fld " + id1 + "\n"
                                + "    fld " + id2 + "\n"
                                + "    fmul \n";
                        usingCOOP = true;
                    }
                } else if (op.equals("DIV")) {
                    asm += "div ";
                    while (!operands.isEmpty()) {
                        asm += operands.remove(0);
                    }
                    asm += "\n";
                } else if (op.equals("SUB")) {
                    asm += "sub ";
                    while (!operands.isEmpty()) {
                        asm += operands.remove(0);
                    }
                    asm += "\n";

                } else if (op.equals("EQ")) {
                    asm += "eq ";
                    while (!operands.isEmpty()) {
                        asm += operands.remove(0);
                    }
                    asm += "\n";

                } else if (op.equals("DIS")) {
                    asm += "dis ";
                    while (!operands.isEmpty()) {
                        asm += operands.remove(0);
                    }
                    asm += "\n";

                } else if (op.equals("LT")) {
                    asm += "lt ";
                    while (!operands.isEmpty()) {
                        asm += operands.remove(0);
                    }
                    asm += "\n";

                } else if (op.equals("GT")) {
                    asm += "gt ";
                    while (!operands.isEmpty()) {
                        asm += operands.remove(0);
                    }
                    asm += "\n";

                } else if (op.equals("LE")) {
                    asm += "le ";
                    while (!operands.isEmpty()) {
                        asm += operands.remove(0);
                    }
                    asm += "\n";

                } else if (op.equals("GE")) {
                    asm += "ge ";
                    while (!operands.isEmpty()) {
                        asm += operands.remove(0);
                    }
                    asm += "\n";

                } else if (op.equals("ASS")) {

                    String d1 = null, d2 = null;
                    d1 = st.getById(
                            operands.remove(
                            operands.size() - 1).cod - rpn.offset);
                    if (!operands.isEmpty()) {
                        d2 = st.getById(operands.remove(0).cod - rpn.offset);
                        SymbolData rval = st.get(d2);
                        String id = (rval.isConstant() ? "CONSTANT" + rval.getId() : d2);
                        asm += "    mov eax," + id + "\n";
                        //if d1 = FLOAT && d2 = INT
                        //  tirar y traer del cop
                        //else if d1 = INT && d2 = FLOAT
                        //  error
                        //else
                        //  no drama
                    } else {
                        if (usingCOOP) {
                            usingCOOP = false;
                            //traer a eax tope pila coop
                        }
                    }
                    asm += "    mov " + d1 + ",eax\n";

                } else if (op.equals("PRN")) {
                    SymbolData rval = st.get(st.getById(operands.remove(0).cod - rpn.offset));
                    asm += "     invoke MessageBox, NULL, addr CONSTANT"
                            + rval.getId() + ", addr CONSTANT" + rval.getId() + ", MB_OK\n";
                } else if (op.equals("JMP")) {
                    asm += "jmp ";
                    while (!operands.isEmpty()) {
                        asm += operands.remove(0);
                    }
                    asm += "\n";

                } else if (op.equals("JIF")) {
                    asm += "jif ";
                    while (!operands.isEmpty()) {
                        asm += operands.remove(0);
                    }
                    asm += "\n";

                }
                code += asm;
            }
        }
        code += "    invoke ExitProcess, 0\n"
                + "end main\n";

        return head + data + code;
    }
}

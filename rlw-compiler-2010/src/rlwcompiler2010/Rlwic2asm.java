/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rlwcompiler2010;

import java.util.Vector;
import sun.security.timestamp.TSRequest;

/**
 *
 * @author je
 */
public class Rlwic2asm {
    Rlwic2asm(){
        String head = ".386\n"+
                ".model flat, stdcall\n"+
                "option casemap :none\n"+
                "include \\masm32\\include\\windows.inc\n"+
                "include \\masm32\\include\\kernel32.inc\n"+
                "include \\masm32\\include\\user32.inc\n"+
                "includelib \\masm32\\lib\\kernel32.lib\n"+
                "includelib \\masm32\\lib\\user32.lib\n";

        String data=".data\n";
        SymbolsTable st = SymbolsTable.get();
        for(String key: st.keySet()){
            SymbolData sdata = st.get(key);
            if(sdata.isConstant()){
                data+="CONSTANT"+sdata.getId()+" db "+key+", 0\n";
            }else{
                data+=key+" ds 4\n";
            }
        }

       String code = ".code\n"+
               "main:"+
               "    mov ax, @data\n"+
               "    mov ds, ax\n";
       ReversePolishNotation rpn = ReversePolishNotation.get();
       Vector<Integer> operands = new Vector<Integer>();

       for(Integer i:rpn.getStrip()){
            if(i>rpn.offset){
            //new operand
                operands.add(0, i);
            }else{
            // new operation
                String asm = "";
                String op = rpn.operation(i);
                if(op.equals("ADD")){
                    String d1=null,d2=null;
                    d1= st.getById(operands.remove(0));
                    SymbolData src = st.get(d1);
                    String id = (src.isConstant()?"CONSTANT"+src.getId():d2);
                    asm += "    mov ebx,"+id+"\n";
                    if(!operands.isEmpty()){
                        d2 = st.getById(operands.remove(0));
                        SymbolData dest = st.get(d2);
                        String id2 = (dest.isConstant()?"CONSTANT"+dest.getId():d2);
                        asm += "    mov eax,"+id2+"\n";
                    }
                    asm += "    add eax,abx\n";

                }else if(op.equals("MUL")){

                }else if(op.equals("DIV")){

                }else if(op.equals("SUB")){

                }else if(op.equals("EQ")){

                }else if(op.equals("DIS")){

                }else if(op.equals("LT")){

                }else if(op.equals("GT")){

                }else if(op.equals("LE")){

                }else if(op.equals("GE")){

                }else if(op.equals("ASS")){

                    String d1=null,d2=null;
                    d1= st.getById(operands.remove(0));
                    if(!operands.isEmpty()){
                        d2 = st.getById(operands.remove(0));
                        SymbolData rval = st.get(d2);
                        String id = (rval.isConstant()?"CONSTANT"+rval.getId():d2);
                        asm += "    mov eax,"+id+"\n";
                        //if d1 = FLOAT && d2 = INT
                        //  tirar y traer del cop
                        //else if d1 = INT && d2 = FLOAT
                        //  error
                        //else
                        //  no drama
                    }
                    asm += "    mov "+d1+",eax\n";

                }else if(op.equals("PRN")){
                    SymbolData rval = st.get(st.getById(operands.remove(0)));
                    asm +="     invoke MessageBox, NULL, addr CONSTANT"+
                        rval.getId()+", addr CONSTANT"+rval.getId()+", MB_OK\n";
                }else if(op.equals("JMP")){

                }else if(op.equals("JIF")){

                }
                code += asm;
            }
       }
       code += "    invoke ExitProcess, 0\n"
            +"end main\n";
    }
}

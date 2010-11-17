/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rlwcompiler2010;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Vector;

/**
 *
 * @author cristian
 */
public class Compiler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           
        if (args.length < 1)
            System.out.println("You need to specify the file to compile.");
        else {
            // This makes the compiler be verbose

            //Logger.get().dontBeShy();
            //Logger.get().mute("Lexer");
            //Logger.get().mute("Compiler");

            try {
                // Init the Scanner
                Rlwlexer.initLexer(args[0]);
                Logger.get().logDebug("Compiler", "Scanner successfully built!");
            } catch (Exception e) {
                Logger.get().logDebug("Compiler", "Something went wrong calling init() on the lexer");
                Logger.get().showException(e);
            }
            // Build a Parser using the Scanner
            Parser p = new Rlwparser(Rlwlexer.getLexer());
            Logger.get().logDebug("Compiler", "Parser successfully built!");
            try {
                Logger.get().logDebug("Compiler", "Now i'm calling parser.parse()...");
                p.parse();
                System.out.println("\nFile " + args[0] + " successfully parsed. Code generated as \'output.asm\'");
            } catch (SemanticErrorException e) {
                System.out.println("\nFile " + args[0] + " contains one or more errors. No code generated ='(");
            } catch (UnsupportedOperationException e) {
                System.out.println(e);
            } catch (Exception e) {
                Logger.get().logDebug("Compiler", "We're screwed! It failed big time!!!");
                Logger.get().showException(e);
                Logger.get().logOutput("Uh Oh! Something went horribly wrong, please debug.");
            }
            System.out.println("\n\n\n\n" + SymbolsTable.get().toString());
            System.out.println(ReversePolishNotation.get().toString());
            try {
                FileWriter fw = new FileWriter("output.asm");
                fw.write(Rlwic2asm.get().getASM());
                fw.close();
            } catch (IOException ex) {
                System.err.println("Cannot write file to 'output.asm'. Obtained " + ex.getStackTrace().toString());
            }
        }
       
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rlwcompiler2010;

import java_cup.runtime.Scanner;

/**
 *
 * @author cristian
 */
public class Compiler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // This makes the compiler be verbose
        Logger.get().unmute();

        try {
            // Init the Scanner
            Rlwlexer.initLexer("test.txt");
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
            Logger.get().logDebug("Compiler", "Finished parsing");
        } catch (Exception e) {
            Logger.get().logDebug("Compiler", "We're screwed! It failed big time!!!");
            Logger.get().showException(e);
            Logger.get().logOutput("Uh Oh! Something went horribly wrong, please debug.");
        }

        
    }

}

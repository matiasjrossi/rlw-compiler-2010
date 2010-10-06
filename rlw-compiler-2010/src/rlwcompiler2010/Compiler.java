/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rlwcompiler2010;

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
        //BEGIN G-parche elputo netbeans no me toma los parametros :S
        {
            args = new String[1];
            args[0]="C:\\Documents and Settings\\G\\Mis documentos\\"
                    +"NetBeansProjects\\trunk\\rlw-compiler-2010\\"
                    +"wrong-program.in";
           // Logger.get().dontBeShy();
        }//END G-parche
                
        if (args.length < 1)
            System.out.println("You need to specify the file to compile.");
        else {
            // This makes the compiler be verbose
            //Logger.get().dontBeShy();

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
                System.out.println("\nFile " + args[0] + " successfully parsed.");
            } catch (Exception e) {
                Logger.get().logDebug("Compiler", "We're screwed! It failed big time!!!");
                Logger.get().showException(e);
                Logger.get().logOutput("Uh Oh! Something went horribly wrong, please debug.");
            }
        }
       
    }

}

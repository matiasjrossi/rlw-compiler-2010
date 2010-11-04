/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rlwcompiler2010;

import java_cup.runtime.Scanner;
import java_cup.runtime.Symbol;

/**
 * @author matias
 */
public class Rlwparser extends Parser {

    Rlwparser(Scanner s) {
        super(s);
    }

    @Override
    public void syntax_error(Symbol errorToken) {
        Logger.get().logDebug("Rlwparser", "call to syntax_error(" + errorToken.toString() + ")");
        
        if (SymbolsHelper.needToSpecify(errorToken.sym))
            Logger.get().logOutput("ERROR: Unexpected " + SymbolsHelper.sym2Sting(errorToken.sym) + ": " + errorToken.value.toString());
        else
            Logger.get().logOutput("ERROR: Unexpected token " + SymbolsHelper.sym2Sting(errorToken.sym));
    }

    @Override
    public void unrecovered_syntax_error(Symbol errorToken) {
        Logger.get().logDebug("Rlwparser", "call to unrecovered_syntax_error(" + errorToken.toString() + ")");
        Logger.get().logOutput("FATAL: The file you gave as input contains too many errors. It is not a valid program.\n\nProcess aborted.");
    }

}

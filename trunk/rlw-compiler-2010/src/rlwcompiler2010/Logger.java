/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rlwcompiler2010;

/**
 *
 * @author matias
 */
public class Logger {
    private boolean enableDebug = false;
    private boolean enableOutput = true;

    public void logDebug(String loggee, String log) {
        if (enableDebug)
            System.out.println("[DEBUG] " + loggee + ": " + log);
    }

    public void logOutput(String s) {
        if (enableOutput)
            System.err.println("At line " + Rlwlexer.getLexer().getCurrentLine() + ": " + s);
    }

    public void showException(Exception e) {
        if (enableDebug)
            e.printStackTrace(System.out);
    }

    /*
     * Enable/disable toggles
     *
     */

    public void mute() {
        enableOutput = false;
        enableDebug = false;
    }

    public void unmute() {
        enableOutput = true;
    }

    public void dontBeShy() {
        enableOutput = true;
        enableDebug = true;
    }

    /*
     * Singleton
     *
     */

    private static Logger logger;

    private Logger(){
    }

    public static Logger get(){
        if (logger == null)
            logger = new Logger();
        return logger;
    }
}

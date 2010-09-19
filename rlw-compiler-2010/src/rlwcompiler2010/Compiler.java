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
        // TODO code application logic here
        try {
            // Build a Scanner
            Scanner s = new Rlwlex("pitogordo.txt");
            System.out.println("Compiler:: Scanner successfully built!");

            // Build a Parser using the previously created Scanner
            Parser p = new Parser(s);
            System.out.println("Compiler:: Parser successfully built!");
            System.out.println("Compiler:: Now i'm calling parser.parse()...");
            p.parse();
            System.out.println("Compiler:: Finished");
        } catch (Exception e) {
            System.out.println("Compiler:: We're screwed! It failed big time!!!");
            e.printStackTrace();
        }

        
    }

}

    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rlwcompiler2010;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Vector;

/**
 *
 * @author cristian
 */
public class Rlwlex {

    private int l = 1; // current line
    private int index = 0; // position src file
    private String strip = ""; // readed chars "buffer"
    private String source; // src ln (from src file)
    private String filePath;
    private State state; // current state
    private State s0; // initial state
    private Vector<Token> tokenStrip;
    private FileReader fr;
    private BufferedReader br;

    Rlwlex(String filePath) throws Exception {
        this.filePath = filePath;
        tokenStrip = new Vector<Token>();

        fr = new FileReader(filePath);
        br = new BufferedReader(fr);

        //set the automata
        s0 = new State(null);
        State s1 = new State(new KeywordTokenizer(this)); //representa Validacion de KeyWords
        State s2 = new State(new IdTokenizer(this));  //representa Validacion de ID
        State s3 = new State(new IntTokenizer(this)); //representa Validacion de Constante Integer


        
        //un caracter
        String regChars = "[a-zA-Z]";
        String regNum = "[0-9]";
        
        s0.addTrans(regChars, s1);
        s0.addTrans(regNum,s3);

        s1.addTrans(regChars, s1);
        s1.addTrans(regNum, s2);

        s2.addTrans(regChars, s2);
        s2.addTrans(regNum, s2);

    }

    protected String nextLine() {
        String s = null;
        try {
            s = br.readLine();
            if (s == null) {
                fr.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    protected Token nextToken() {
        Token t = null;

        while (t == null) {
            if (source == null || source.length() <= index) {
                source = nextLine();
                index = 0;
                if (source == null) {
                    //
                    return makeToken(strip);
                }
            }
            char c = source.charAt(index++);
            State ns = state.next(c);

            if (ns != null) { // si tengo transicion, todo va bien
                strip += c;
                state = ns;
            } else {// si no tengo prox estado es final (valido-ERROR)
                t = makeToken(strip);
                //corregir index y strip pa que salga andando
                // el char actual es el que no valida con el estado acutal -> proximo token
                strip = String.valueOf(c);
                state = s0.next(c);
            }
        }
        return t;
    }

    public void log(String s) {
        System.out.println("Line <" + l + ">: " + s);
    }

    private Token makeToken(String strip) {
        Token t = state.getToken(strip);
        if (t != null) {
            // buscar en tsimbolo
            //    si no ta agregar
            tokenStrip.add(t);
        }
        return t;
    }
}

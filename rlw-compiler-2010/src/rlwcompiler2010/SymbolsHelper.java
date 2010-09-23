/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rlwcompiler2010;

/**
 *
 * @author matias
 */
public class SymbolsHelper {

    public static String sym2Sting(int s) {
        switch (s) {
          case Symbols.TIMES:
               return new String("\'*\'");
          case Symbols.SEMICOLON:
              return new String("\';\'");
          case Symbols.ELSE:
              return new String("\'else\'");
          case Symbols.PLUS:
              return new String("\'+\'");
          case Symbols.CONSTANT:
              return new String("constant");
          case Symbols.RCURLY:
              return new String("\'}\'");
          case Symbols.IDENTIFIER:
              return new String("identifier");
          case Symbols.IF:
              return new String("\'if\'");
          case Symbols.LBRACKET:
              return new String("\'(\'");
          case Symbols.COMPARATOR:
              return new String("comparator");
          case Symbols.RBRACKET:
              return new String("\')\'");
          case Symbols.LCURLY:
              return new String("\'{\'");
          case Symbols.TYPE:
              return new String("type name");
          case Symbols.COMMA:
              return new String("\',\'");
          case Symbols.EOF:
              return new String("\'END-OF-FILE\'");
          case Symbols.BY:
              return new String("\'/\'");
          case Symbols.ASSIGNMENTSYMBOL:
              return new String("\':-\'");
          case Symbols.MINUS:
              return new String("\'-\'");
          case Symbols.PRINT:
              return new String("\'print\'");
          case Symbols.error:
              return new String("\'ERROR TOKEN\'");
          case Symbols.FOR:
              return new String("\'for\'");
        }
        return null;
    }

    public static boolean needToSpecify(int s) {
        switch (s) {
          case Symbols.CONSTANT:
          case Symbols.IDENTIFIER:
          case Symbols.COMPARATOR:
          case Symbols.TYPE:
              return true;
        }
        return false;
    }
}

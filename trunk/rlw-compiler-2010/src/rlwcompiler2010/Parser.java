
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Sun Sep 19 17:35:25 ART 2010
//----------------------------------------------------

package rlwcompiler2010;

import java_cup.runtime.*;

/** CUP v0.11a beta 20060608 generated parser.
  * @version Sun Sep 19 17:35:25 ART 2010
  */
public class Parser extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public Parser() {super();}

  /** Constructor which sets the default scanner. */
  public Parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public Parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\041\000\002\002\004\000\002\002\004\000\002\002" +
    "\003\000\002\006\004\000\002\006\003\000\002\005\005" +
    "\000\002\022\005\000\002\022\003\000\002\021\005\000" +
    "\002\021\003\000\002\014\004\000\002\014\003\000\002" +
    "\017\005\000\002\017\004\000\002\011\005\000\002\011" +
    "\003\000\002\016\003\000\002\016\003\000\002\016\003" +
    "\000\002\003\005\000\002\007\005\000\002\007\005\000" +
    "\002\007\003\000\002\020\005\000\002\020\005\000\002" +
    "\020\003\000\002\010\003\000\002\010\003\000\002\015" +
    "\011\000\002\004\004\000\002\004\005\000\002\012\005" +
    "\000\002\013\006" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\101\000\014\012\015\013\010\015\020\024\011\025" +
    "\014\001\002\000\016\002\uffef\012\uffef\013\uffef\015\uffef" +
    "\022\uffef\025\uffef\001\002\000\016\002\ufff1\012\ufff1\013" +
    "\ufff1\015\ufff1\022\ufff1\025\ufff1\001\002\000\014\012\ufffd" +
    "\013\ufffd\015\ufffd\024\ufffd\025\ufffd\001\002\000\004\002" +
    "\103\001\002\000\004\014\065\001\002\000\004\012\061" +
    "\001\002\000\016\002\ufff8\012\ufff8\013\ufff8\015\ufff8\022" +
    "\ufff8\025\ufff8\001\002\000\014\002\uffff\012\015\013\010" +
    "\015\020\025\014\001\002\000\004\014\055\001\002\000" +
    "\004\004\037\001\002\000\014\002\ufffa\012\ufffa\013\ufffa" +
    "\015\ufffa\025\ufffa\001\002\000\016\002\ufff0\012\ufff0\013" +
    "\ufff0\015\ufff0\022\ufff0\025\ufff0\001\002\000\012\012\015" +
    "\013\010\024\011\025\014\001\002\000\014\012\015\013" +
    "\010\015\020\024\011\025\014\001\002\000\014\012\ufffe" +
    "\013\ufffe\015\ufffe\024\ufffe\025\ufffe\001\002\000\014\002" +
    "\001\012\015\013\010\015\020\025\014\001\002\000\004" +
    "\022\025\001\002\000\014\002\ufffb\012\ufffb\013\ufffb\015" +
    "\ufffb\025\ufffb\001\002\000\012\012\015\013\010\021\ufff6" +
    "\025\014\001\002\000\004\022\036\001\002\000\004\021" +
    "\035\001\002\000\012\012\015\013\010\024\011\025\014" +
    "\001\002\000\012\012\015\013\010\021\ufff7\025\014\001" +
    "\002\000\004\022\034\001\002\000\012\012\ufff5\013\ufff5" +
    "\021\ufff5\025\ufff5\001\002\000\016\002\ufff9\012\ufff9\013" +
    "\ufff9\015\ufff9\022\ufff9\025\ufff9\001\002\000\012\012\ufff4" +
    "\013\ufff4\021\ufff4\025\ufff4\001\002\000\006\010\040\012" +
    "\043\001\002\000\032\002\uffe6\005\uffe6\007\uffe6\012\uffe6" +
    "\013\uffe6\015\uffe6\016\uffe6\017\uffe6\020\uffe6\022\uffe6\023" +
    "\uffe6\025\uffe6\001\002\000\032\002\uffeb\005\051\007\uffeb" +
    "\012\uffeb\013\uffeb\015\uffeb\016\uffeb\017\uffeb\020\uffeb\022" +
    "\uffeb\023\050\025\uffeb\001\002\000\032\002\uffe8\005\uffe8" +
    "\007\uffe8\012\uffe8\013\uffe8\015\uffe8\016\uffe8\017\uffe8\020" +
    "\uffe8\022\uffe8\023\uffe8\025\uffe8\001\002\000\032\002\uffe7" +
    "\005\uffe7\007\uffe7\012\uffe7\013\uffe7\015\uffe7\016\uffe7\017" +
    "\uffe7\020\uffe7\022\uffe7\023\uffe7\025\uffe7\001\002\000\022" +
    "\002\uffee\012\uffee\013\uffee\015\uffee\016\046\017\045\022" +
    "\uffee\025\uffee\001\002\000\006\010\040\012\043\001\002" +
    "\000\006\010\040\012\043\001\002\000\032\002\uffec\005" +
    "\051\007\uffec\012\uffec\013\uffec\015\uffec\016\uffec\017\uffec" +
    "\020\uffec\022\uffec\023\050\025\uffec\001\002\000\006\010" +
    "\040\012\043\001\002\000\006\010\040\012\043\001\002" +
    "\000\032\002\uffe9\005\uffe9\007\uffe9\012\uffe9\013\uffe9\015" +
    "\uffe9\016\uffe9\017\uffe9\020\uffe9\022\uffe9\023\uffe9\025\uffe9" +
    "\001\002\000\032\002\uffea\005\uffea\007\uffea\012\uffea\013" +
    "\uffea\015\uffea\016\uffea\017\uffea\020\uffea\022\uffea\023\uffea" +
    "\025\uffea\001\002\000\032\002\uffed\005\051\007\uffed\012" +
    "\uffed\013\uffed\015\uffed\016\uffed\017\uffed\020\uffed\022\uffed" +
    "\023\050\025\uffed\001\002\000\004\010\056\001\002\000" +
    "\004\020\057\001\002\000\016\002\uffe1\012\uffe1\013\uffe1" +
    "\015\uffe1\022\uffe1\025\uffe1\001\002\000\006\006\062\022" +
    "\063\001\002\000\006\006\ufff2\022\ufff2\001\002\000\004" +
    "\012\064\001\002\000\014\012\ufffc\013\ufffc\015\ufffc\024" +
    "\ufffc\025\ufffc\001\002\000\006\006\ufff3\022\ufff3\001\002" +
    "\000\006\010\040\012\043\001\002\000\004\020\072\001" +
    "\002\000\010\007\070\016\046\017\045\001\002\000\006" +
    "\010\040\012\043\001\002\000\010\016\046\017\045\020" +
    "\uffe2\001\002\000\012\012\015\013\010\015\075\025\014" +
    "\001\002\000\004\011\101\001\002\000\004\022\100\001" +
    "\002\000\010\012\015\013\010\025\014\001\002\000\012" +
    "\012\015\013\010\021\077\025\014\001\002\000\020\002" +
    "\uffe3\011\uffe3\012\uffe3\013\uffe3\015\uffe3\022\uffe3\025\uffe3" +
    "\001\002\000\020\002\uffe4\011\uffe4\012\uffe4\013\uffe4\015" +
    "\uffe4\022\uffe4\025\uffe4\001\002\000\012\012\015\013\010" +
    "\015\075\025\014\001\002\000\016\002\uffe5\012\uffe5\013" +
    "\uffe5\015\uffe5\022\uffe5\025\uffe5\001\002\000\004\002\000" +
    "\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\101\000\024\002\006\003\004\005\005\006\020\013" +
    "\003\015\016\016\011\021\015\022\012\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\004\011\057\001\001\000\002" +
    "\001\001\000\014\003\004\013\003\015\016\016\011\021" +
    "\023\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\022\003\004\005\005\006" +
    "\030\013\003\014\027\015\016\016\026\017\025\001\001" +
    "\000\020\003\004\005\021\013\003\015\016\016\011\021" +
    "\015\022\022\001\001\000\002\001\001\000\014\003\004" +
    "\013\003\015\016\016\011\021\023\001\001\000\002\001" +
    "\001\000\002\001\001\000\012\003\004\013\003\015\016" +
    "\016\032\001\001\000\002\001\001\000\002\001\001\000" +
    "\016\003\004\005\021\013\003\015\016\016\026\017\031" +
    "\001\001\000\012\003\004\013\003\015\016\016\032\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\010\007\043\010\041\020\040\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\006\010\041\020" +
    "\053\001\001\000\006\010\041\020\046\001\001\000\002" +
    "\001\001\000\004\010\052\001\001\000\004\010\051\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\012\007\066\010\041\012" +
    "\065\020\040\001\001\000\002\001\001\000\002\001\001" +
    "\000\010\007\070\010\041\020\040\001\001\000\002\001" +
    "\001\000\014\003\004\004\072\013\003\015\016\016\073" +
    "\001\001\000\002\001\001\000\002\001\001\000\014\003" +
    "\004\013\003\015\016\016\026\017\075\001\001\000\012" +
    "\003\004\013\003\015\016\016\032\001\001\000\002\001" +
    "\001\000\002\001\001\000\014\003\004\004\101\013\003" +
    "\015\016\016\073\001\001\000\002\001\001\000\002\001" +
    "\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$Parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$Parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$Parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$Parser$actions {
  private final Parser parser;

  /** Constructor */
  CUP$Parser$actions(Parser parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$Parser$result;

      /* select the action based on the action number */
      switch (CUP$Parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 32: // print ::= PRINT LBRACKET CONSTANT RBRACKET 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("print",9, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 31: // predicate ::= expresion COMPARATOR expresion 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("predicate",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 30: // block ::= LCURLY statements RCURLY 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("block",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 29: // block ::= statement SEMICOLON 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("block",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // selection ::= IF LBRACKET predicate RBRACKET block ELSE block 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("selection",11, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-6)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // factor ::= CONSTANT 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("factor",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // factor ::= IDENTIFIER 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("factor",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // term ::= factor 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("term",14, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // term ::= term BY factor 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("term",14, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // term ::= term TIMES factor 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("term",14, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // expresion ::= term 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expresion",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // expresion ::= expresion MINUS term 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expresion",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // expresion ::= expresion PLUS term 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expresion",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // assignment ::= IDENTIFIER ASSIGNMENTSYMBOL expresion 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("assignment",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // statement ::= print 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // statement ::= selection 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // statement ::= assignment 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // identifiers ::= IDENTIFIER 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("identifiers",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // identifiers ::= identifiers COMMA IDENTIFIER 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("identifiers",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // statements ::= statement SEMICOLON 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statements",13, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // statements ::= statements statement SEMICOLON 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statements",13, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // scope ::= statements 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("scope",10, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // scope ::= declarations statements 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("scope",10, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // firstlevelstatement ::= statement 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("firstlevelstatement",15, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // firstlevelstatement ::= LCURLY scope RCURLY 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("firstlevelstatement",15, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // firstlevelstatements ::= firstlevelstatement 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("firstlevelstatements",16, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // firstlevelstatements ::= firstlevelstatements firstlevelstatement SEMICOLON 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("firstlevelstatements",16, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // declaration ::= TYPE identifiers SEMICOLON 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("declaration",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // declarations ::= declaration 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("declarations",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // declarations ::= declarations declaration 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("declarations",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // program ::= firstlevelstatements 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("program",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= program EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		RESULT = start_val;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$Parser$parser.done_parsing();
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // program ::= declarations firstlevelstatements 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("program",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}


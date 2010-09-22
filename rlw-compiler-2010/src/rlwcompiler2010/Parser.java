
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Wed Sep 22 09:23:00 ART 2010
//----------------------------------------------------

package rlwcompiler2010;

import java_cup.runtime.*;

/** CUP v0.11a beta 20060608 generated parser.
  * @version Wed Sep 22 09:23:00 ART 2010
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
    "\000\043\000\002\002\004\000\002\002\004\000\002\002" +
    "\003\000\002\006\004\000\002\006\003\000\002\005\005" +
    "\000\002\022\004\000\002\022\003\000\002\021\005\000" +
    "\002\021\003\000\002\014\004\000\002\014\003\000\002" +
    "\017\004\000\002\017\003\000\002\011\005\000\002\011" +
    "\003\000\002\016\003\000\002\016\003\000\002\016\003" +
    "\000\002\003\006\000\002\007\005\000\002\007\005\000" +
    "\002\007\003\000\002\020\005\000\002\020\005\000\002" +
    "\020\003\000\002\010\003\000\002\010\003\000\002\015" +
    "\011\000\002\004\003\000\002\004\005\000\002\012\005" +
    "\000\002\013\007\000\002\016\004\000\002\016\005" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\105\000\016\003\013\012\017\013\010\015\021\024" +
    "\011\025\015\001\002\000\022\002\uffef\003\uffef\011\uffef" +
    "\012\uffef\013\uffef\015\uffef\021\uffef\025\uffef\001\002\000" +
    "\022\002\ufff1\003\ufff1\011\ufff1\012\ufff1\013\ufff1\015\ufff1" +
    "\021\ufff1\025\ufff1\001\002\000\016\003\ufffd\012\ufffd\013" +
    "\ufffd\015\ufffd\024\ufffd\025\ufffd\001\002\000\004\002\107" +
    "\001\002\000\004\014\072\001\002\000\004\012\066\001" +
    "\002\000\016\002\ufff8\003\ufff8\012\ufff8\013\ufff8\015\ufff8" +
    "\025\ufff8\001\002\000\004\022\041\001\002\000\016\002" +
    "\uffff\003\013\012\017\013\010\015\021\025\015\001\002" +
    "\000\004\014\061\001\002\000\016\002\ufffa\003\ufffa\012" +
    "\ufffa\013\ufffa\015\ufffa\025\ufffa\001\002\000\004\004\042" +
    "\001\002\000\022\002\ufff0\003\ufff0\011\ufff0\012\ufff0\013" +
    "\ufff0\015\ufff0\021\ufff0\025\ufff0\001\002\000\016\003\030" +
    "\012\017\013\010\015\031\024\011\025\015\001\002\000" +
    "\016\003\013\012\017\013\010\015\021\024\011\025\015" +
    "\001\002\000\016\003\ufffe\012\ufffe\013\ufffe\015\ufffe\024" +
    "\ufffe\025\ufffe\001\002\000\016\002\001\003\013\012\017" +
    "\013\010\015\021\025\015\001\002\000\016\002\ufffb\003" +
    "\ufffb\012\ufffb\013\ufffb\015\ufffb\025\ufffb\001\002\000\016" +
    "\003\013\012\017\013\010\015\031\021\ufff6\025\015\001" +
    "\002\000\016\003\ufff4\012\ufff4\013\ufff4\015\ufff4\021\ufff4" +
    "\025\ufff4\001\002\000\006\021\040\022\041\001\002\000" +
    "\004\003\037\001\002\000\004\021\036\001\002\000\016" +
    "\003\013\012\017\013\010\015\031\024\011\025\015\001" +
    "\002\000\016\003\013\012\017\013\010\015\031\021\ufff7" +
    "\025\015\001\002\000\016\003\ufff5\012\ufff5\013\ufff5\015" +
    "\ufff5\021\ufff5\025\ufff5\001\002\000\016\002\ufff9\003\ufff9" +
    "\012\ufff9\013\ufff9\015\ufff9\025\ufff9\001\002\000\004\021" +
    "\040\001\002\000\022\002\uffdf\003\uffdf\011\uffdf\012\uffdf" +
    "\013\uffdf\015\uffdf\021\uffdf\025\uffdf\001\002\000\022\002" +
    "\uffe0\003\uffe0\011\uffe0\012\uffe0\013\uffe0\015\uffe0\021\uffe0" +
    "\025\uffe0\001\002\000\006\010\043\012\046\001\002\000" +
    "\020\005\uffe6\007\uffe6\016\uffe6\017\uffe6\020\uffe6\022\uffe6" +
    "\023\uffe6\001\002\000\020\005\055\007\uffeb\016\uffeb\017" +
    "\uffeb\020\uffeb\022\uffeb\023\054\001\002\000\020\005\uffe8" +
    "\007\uffe8\016\uffe8\017\uffe8\020\uffe8\022\uffe8\023\uffe8\001" +
    "\002\000\020\005\uffe7\007\uffe7\016\uffe7\017\uffe7\020\uffe7" +
    "\022\uffe7\023\uffe7\001\002\000\010\016\052\017\051\022" +
    "\050\001\002\000\022\002\uffee\003\uffee\011\uffee\012\uffee" +
    "\013\uffee\015\uffee\021\uffee\025\uffee\001\002\000\006\010" +
    "\043\012\046\001\002\000\006\010\043\012\046\001\002" +
    "\000\020\005\055\007\uffec\016\uffec\017\uffec\020\uffec\022" +
    "\uffec\023\054\001\002\000\006\010\043\012\046\001\002" +
    "\000\006\010\043\012\046\001\002\000\020\005\uffe9\007" +
    "\uffe9\016\uffe9\017\uffe9\020\uffe9\022\uffe9\023\uffe9\001\002" +
    "\000\020\005\uffea\007\uffea\016\uffea\017\uffea\020\uffea\022" +
    "\uffea\023\uffea\001\002\000\020\005\055\007\uffed\016\uffed" +
    "\017\uffed\020\uffed\022\uffed\023\054\001\002\000\004\010" +
    "\062\001\002\000\004\020\063\001\002\000\004\022\064" +
    "\001\002\000\022\002\uffe1\003\uffe1\011\uffe1\012\uffe1\013" +
    "\uffe1\015\uffe1\021\uffe1\025\uffe1\001\002\000\006\006\067" +
    "\022\070\001\002\000\006\006\ufff2\022\ufff2\001\002\000" +
    "\004\012\071\001\002\000\016\003\ufffc\012\ufffc\013\ufffc" +
    "\015\ufffc\024\ufffc\025\ufffc\001\002\000\006\006\ufff3\022" +
    "\ufff3\001\002\000\006\010\043\012\046\001\002\000\004" +
    "\020\077\001\002\000\010\007\075\016\052\017\051\001" +
    "\002\000\006\010\043\012\046\001\002\000\010\016\052" +
    "\017\051\020\uffe2\001\002\000\014\003\013\012\017\013" +
    "\010\015\102\025\015\001\002\000\004\011\105\001\002" +
    "\000\022\002\uffe4\003\uffe4\011\uffe4\012\uffe4\013\uffe4\015" +
    "\uffe4\021\uffe4\025\uffe4\001\002\000\014\003\030\012\017" +
    "\013\010\015\031\025\015\001\002\000\016\003\013\012" +
    "\017\013\010\015\031\021\104\025\015\001\002\000\022" +
    "\002\uffe3\003\uffe3\011\uffe3\012\uffe3\013\uffe3\015\uffe3\021" +
    "\uffe3\025\uffe3\001\002\000\014\003\013\012\017\013\010" +
    "\015\102\025\015\001\002\000\022\002\uffe5\003\uffe5\011" +
    "\uffe5\012\uffe5\013\uffe5\015\uffe5\021\uffe5\025\uffe5\001\002" +
    "\000\004\002\000\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\105\000\024\002\006\003\004\005\005\006\021\013" +
    "\003\015\017\016\011\021\015\022\013\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\004\011\064\001\001\000\002" +
    "\001\001\000\002\001\001\000\014\003\004\013\003\015" +
    "\017\016\011\021\024\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\022\003" +
    "\004\005\005\006\032\013\003\014\031\015\017\016\026" +
    "\017\025\001\001\000\020\003\004\005\022\013\003\015" +
    "\017\016\011\021\015\022\023\001\001\000\002\001\001" +
    "\000\014\003\004\013\003\015\017\016\011\021\024\001" +
    "\001\000\002\001\001\000\012\003\004\013\003\015\017" +
    "\016\034\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\016\003\004\005\022" +
    "\013\003\015\017\016\026\017\033\001\001\000\012\003" +
    "\004\013\003\015\017\016\034\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\010\007\046\010\044\020\043\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\006" +
    "\010\044\020\057\001\001\000\006\010\044\020\052\001" +
    "\001\000\002\001\001\000\004\010\056\001\001\000\004" +
    "\010\055\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\012\007\073\010\044\012\072\020\043\001\001\000" +
    "\002\001\001\000\002\001\001\000\010\007\075\010\044" +
    "\020\043\001\001\000\002\001\001\000\014\003\004\004" +
    "\077\013\003\015\017\016\100\001\001\000\002\001\001" +
    "\000\002\001\001\000\014\003\004\013\003\015\017\016" +
    "\026\017\102\001\001\000\012\003\004\013\003\015\017" +
    "\016\034\001\001\000\002\001\001\000\014\003\004\004" +
    "\105\013\003\015\017\016\100\001\001\000\002\001\001" +
    "\000\002\001\001" });

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
          case 34: // statement ::= LCURLY error RCURLY 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 33: // statement ::= error SEMICOLON 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 32: // print ::= PRINT LBRACKET CONSTANT RBRACKET SEMICOLON 
            {
              Object RESULT =null;
		 System.out.println("Parser:: Using rule: print ::= PRINT LBRACKET CONSTANT RBRACKET SEMICOLON"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("print",9, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 31: // predicate ::= expresion COMPARATOR expresion 
            {
              Object RESULT =null;
		 System.out.println("Parser:: Using rule: predicate ::= expresion COMPARATOR expresion"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("predicate",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 30: // block ::= LCURLY statements RCURLY 
            {
              Object RESULT =null;
		 System.out.println("Parser:: Using rule: block ::= LCURLY statements RCURLY"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("block",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 29: // block ::= statement 
            {
              Object RESULT =null;
		 System.out.println("Parser:: Using rule: block ::= statement"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("block",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // selection ::= IF LBRACKET predicate RBRACKET block ELSE block 
            {
              Object RESULT =null;
		 System.out.println("Parser:: Using rule: selection ::= IF LBRACKET predicate RBRACKET block ELSE block"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("selection",11, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-6)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // factor ::= CONSTANT 
            {
              Object RESULT =null;
		 System.out.println("Parser:: Using rule: factor ::= CONSTANT"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("factor",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // factor ::= IDENTIFIER 
            {
              Object RESULT =null;
		 System.out.println("Parser:: Using rule: factor ::= IDENTIFIER"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("factor",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // term ::= factor 
            {
              Object RESULT =null;
		 System.out.println("Parser:: Using rule: term ::= factor"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("term",14, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // term ::= term BY factor 
            {
              Object RESULT =null;
		 System.out.println("Parser:: Using rule: term ::= term BY factor"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("term",14, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // term ::= term TIMES factor 
            {
              Object RESULT =null;
		 System.out.println("Parser:: Using rule: term ::= term TIMES factor"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("term",14, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // expresion ::= term 
            {
              Object RESULT =null;
		 System.out.println("Parser:: Using rule: expresion ::= term"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expresion",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // expresion ::= expresion MINUS term 
            {
              Object RESULT =null;
		 System.out.println("Parser:: Using rule: expresion ::= expresion MINUS term"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expresion",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // expresion ::= expresion PLUS term 
            {
              Object RESULT =null;
		 System.out.println("Parser:: Using rule: expresion ::= expresion PLUS term"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expresion",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // assignment ::= IDENTIFIER ASSIGNMENTSYMBOL expresion SEMICOLON 
            {
              Object RESULT =null;
		 System.out.println("Parser:: Using rule: assignment ::= IDENTIFIER ASSIGNMENTSYMBOL expresion SEMICOLON"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("assignment",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // statement ::= print 
            {
              Object RESULT =null;
		 System.out.println("Parser:: Using rule: statement ::= print"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // statement ::= selection 
            {
              Object RESULT =null;
		 System.out.println("Parser:: Using rule: statement ::= selection"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // statement ::= assignment 
            {
              Object RESULT =null;
		 System.out.println("Parser:: Using rule: statement ::= assignment"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // identifiers ::= IDENTIFIER 
            {
              Object RESULT =null;
		 System.out.println("Parser:: Using rule: identifiers ::= IDENTIFIER"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("identifiers",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // identifiers ::= identifiers COMMA IDENTIFIER 
            {
              Object RESULT =null;
		 System.out.println("Parser:: Using rule: identifiers ::= identifiers COMMA IDENTIFIER"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("identifiers",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // statements ::= statement 
            {
              Object RESULT =null;
		 System.out.println("Parser:: Using rule: statements ::= statement"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statements",13, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // statements ::= statements statement 
            {
              Object RESULT =null;
		 System.out.println("Parser:: Using rule: statements ::= statements statement"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statements",13, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // scope ::= statements 
            {
              Object RESULT =null;
		 System.out.println("Parser:: Using rule: scope ::= statements"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("scope",10, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // scope ::= declarations statements 
            {
              Object RESULT =null;
		 System.out.println("Parser:: Using rule: scope ::= declarations statements"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("scope",10, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // firstlevelstatement ::= statement 
            {
              Object RESULT =null;
		 System.out.println("Parser:: Using rule: firstlevelstatement ::= statement"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("firstlevelstatement",15, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // firstlevelstatement ::= LCURLY scope RCURLY 
            {
              Object RESULT =null;
		 System.out.println("Parser:: Using rule: firstlevelstatement ::= LCURLY scope RCURLY"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("firstlevelstatement",15, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // firstlevelstatements ::= firstlevelstatement 
            {
              Object RESULT =null;
		 System.out.println("Parser:: Using rule: firstlevelstatements ::= firstlevelstatement"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("firstlevelstatements",16, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // firstlevelstatements ::= firstlevelstatements firstlevelstatement 
            {
              Object RESULT =null;
		 System.out.println("Parser:: Using rule: firstlevelstatements ::= firstlevelstatements firstlevelstatement"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("firstlevelstatements",16, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // declaration ::= TYPE identifiers SEMICOLON 
            {
              Object RESULT =null;
		 System.out.println("Parser:: Using rule: declaration ::= TYPE identifiers SEMICOLON"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("declaration",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // declarations ::= declaration 
            {
              Object RESULT =null;
		 System.out.println("Parser:: Using rule: declarations ::= declaration"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("declarations",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // declarations ::= declarations declaration 
            {
              Object RESULT =null;
		 System.out.println("Parser:: Using rule: declarations ::= declarations declaration"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("declarations",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // program ::= firstlevelstatements 
            {
              Object RESULT =null;
		 System.out.println("Parser:: Using rule: program ::= firstlevelstatements"); 
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
		 System.out.println("Parser:: Using rule: program ::= declarations firstlevelstatements"); 
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


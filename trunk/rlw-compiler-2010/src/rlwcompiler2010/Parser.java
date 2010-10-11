
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Mon Oct 11 16:11:47 ART 2010
//----------------------------------------------------

package rlwcompiler2010;

import java_cup.runtime.*;

/** CUP v0.11a beta 20060608 generated parser.
  * @version Mon Oct 11 16:11:47 ART 2010
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
    "\000\053\000\002\002\004\000\002\002\004\000\002\002" +
    "\003\000\002\006\004\000\002\006\003\000\002\005\005" +
    "\000\002\022\004\000\002\022\003\000\002\021\005\000" +
    "\002\021\003\000\002\014\004\000\002\014\003\000\002" +
    "\017\004\000\002\017\003\000\002\011\005\000\002\011" +
    "\003\000\002\016\003\000\002\016\003\000\002\016\003" +
    "\000\002\016\003\000\002\003\006\000\002\007\005\000" +
    "\002\007\005\000\002\007\003\000\002\020\005\000\002" +
    "\020\005\000\002\020\003\000\002\010\003\000\002\010" +
    "\003\000\002\015\011\000\002\004\003\000\002\004\005" +
    "\000\002\012\005\000\002\013\007\000\002\023\013\000" +
    "\002\024\005\000\002\024\005\000\002\025\005\000\002" +
    "\025\005\000\002\026\003\000\002\026\003\000\002\016" +
    "\004\000\002\016\005" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\131\000\020\003\015\012\021\013\012\015\023\024" +
    "\013\025\017\026\005\001\002\000\024\002\uffef\003\uffef" +
    "\011\uffef\012\uffef\013\uffef\015\uffef\021\uffef\025\uffef\026" +
    "\uffef\001\002\000\004\014\112\001\002\000\024\002\ufff1" +
    "\003\ufff1\011\ufff1\012\ufff1\013\ufff1\015\ufff1\021\ufff1\025" +
    "\ufff1\026\ufff1\001\002\000\020\003\ufffd\012\ufffd\013\ufffd" +
    "\015\ufffd\024\ufffd\025\ufffd\026\ufffd\001\002\000\004\002" +
    "\111\001\002\000\024\002\uffee\003\uffee\011\uffee\012\uffee" +
    "\013\uffee\015\uffee\021\uffee\025\uffee\026\uffee\001\002\000" +
    "\004\014\074\001\002\000\004\012\070\001\002\000\020" +
    "\002\ufff8\003\ufff8\012\ufff8\013\ufff8\015\ufff8\025\ufff8\026" +
    "\ufff8\001\002\000\004\022\043\001\002\000\020\002\uffff" +
    "\003\015\012\021\013\012\015\023\025\017\026\005\001" +
    "\002\000\004\014\063\001\002\000\020\002\ufffa\003\ufffa" +
    "\012\ufffa\013\ufffa\015\ufffa\025\ufffa\026\ufffa\001\002\000" +
    "\004\004\044\001\002\000\024\002\ufff0\003\ufff0\011\ufff0" +
    "\012\ufff0\013\ufff0\015\ufff0\021\ufff0\025\ufff0\026\ufff0\001" +
    "\002\000\020\003\031\012\021\013\012\015\033\024\013" +
    "\025\017\026\005\001\002\000\020\003\015\012\021\013" +
    "\012\015\023\024\013\025\017\026\005\001\002\000\020" +
    "\003\ufffe\012\ufffe\013\ufffe\015\ufffe\024\ufffe\025\ufffe\026" +
    "\ufffe\001\002\000\020\002\001\003\015\012\021\013\012" +
    "\015\023\025\017\026\005\001\002\000\020\002\ufffb\003" +
    "\ufffb\012\ufffb\013\ufffb\015\ufffb\025\ufffb\026\ufffb\001\002" +
    "\000\020\003\015\012\021\013\012\015\033\021\ufff6\025" +
    "\017\026\005\001\002\000\006\021\042\022\043\001\002" +
    "\000\020\003\ufff4\012\ufff4\013\ufff4\015\ufff4\021\ufff4\025" +
    "\ufff4\026\ufff4\001\002\000\004\003\041\001\002\000\004" +
    "\021\040\001\002\000\020\003\015\012\021\013\012\015" +
    "\033\024\013\025\017\026\005\001\002\000\020\003\015" +
    "\012\021\013\012\015\033\021\ufff7\025\017\026\005\001" +
    "\002\000\020\003\ufff5\012\ufff5\013\ufff5\015\ufff5\021\ufff5" +
    "\025\ufff5\026\ufff5\001\002\000\020\002\ufff9\003\ufff9\012" +
    "\ufff9\013\ufff9\015\ufff9\025\ufff9\026\ufff9\001\002\000\004" +
    "\021\042\001\002\000\024\002\uffd7\003\uffd7\011\uffd7\012" +
    "\uffd7\013\uffd7\015\uffd7\021\uffd7\025\uffd7\026\uffd7\001\002" +
    "\000\024\002\uffd8\003\uffd8\011\uffd8\012\uffd8\013\uffd8\015" +
    "\uffd8\021\uffd8\025\uffd8\026\uffd8\001\002\000\006\010\045" +
    "\012\050\001\002\000\020\005\uffe5\007\uffe5\016\uffe5\017" +
    "\uffe5\020\uffe5\022\uffe5\023\uffe5\001\002\000\020\005\uffe7" +
    "\007\uffe7\016\uffe7\017\uffe7\020\uffe7\022\uffe7\023\uffe7\001" +
    "\002\000\020\005\056\007\uffea\016\uffea\017\uffea\020\uffea" +
    "\022\uffea\023\057\001\002\000\020\005\uffe6\007\uffe6\016" +
    "\uffe6\017\uffe6\020\uffe6\022\uffe6\023\uffe6\001\002\000\010" +
    "\016\054\017\053\022\052\001\002\000\024\002\uffed\003" +
    "\uffed\011\uffed\012\uffed\013\uffed\015\uffed\021\uffed\025\uffed" +
    "\026\uffed\001\002\000\006\010\045\012\050\001\002\000" +
    "\006\010\045\012\050\001\002\000\020\005\056\007\uffeb" +
    "\016\uffeb\017\uffeb\020\uffeb\022\uffeb\023\057\001\002\000" +
    "\006\010\045\012\050\001\002\000\006\010\045\012\050" +
    "\001\002\000\020\005\uffe9\007\uffe9\016\uffe9\017\uffe9\020" +
    "\uffe9\022\uffe9\023\uffe9\001\002\000\020\005\uffe8\007\uffe8" +
    "\016\uffe8\017\uffe8\020\uffe8\022\uffe8\023\uffe8\001\002\000" +
    "\020\005\056\007\uffec\016\uffec\017\uffec\020\uffec\022\uffec" +
    "\023\057\001\002\000\004\010\064\001\002\000\004\020" +
    "\065\001\002\000\004\022\066\001\002\000\024\002\uffe0" +
    "\003\uffe0\011\uffe0\012\uffe0\013\uffe0\015\uffe0\021\uffe0\025" +
    "\uffe0\026\uffe0\001\002\000\006\006\071\022\072\001\002" +
    "\000\006\006\ufff2\022\ufff2\001\002\000\004\012\073\001" +
    "\002\000\020\003\ufffc\012\ufffc\013\ufffc\015\ufffc\024\ufffc" +
    "\025\ufffc\026\ufffc\001\002\000\006\006\ufff3\022\ufff3\001" +
    "\002\000\006\010\045\012\050\001\002\000\004\020\101" +
    "\001\002\000\010\007\077\016\054\017\053\001\002\000" +
    "\006\010\045\012\050\001\002\000\010\016\054\017\053" +
    "\020\uffe1\001\002\000\016\003\015\012\021\013\012\015" +
    "\104\025\017\026\005\001\002\000\004\011\107\001\002" +
    "\000\024\002\uffe3\003\uffe3\011\uffe3\012\uffe3\013\uffe3\015" +
    "\uffe3\021\uffe3\025\uffe3\026\uffe3\001\002\000\016\003\031" +
    "\012\021\013\012\015\033\025\017\026\005\001\002\000" +
    "\020\003\015\012\021\013\012\015\033\021\106\025\017" +
    "\026\005\001\002\000\024\002\uffe2\003\uffe2\011\uffe2\012" +
    "\uffe2\013\uffe2\015\uffe2\021\uffe2\025\uffe2\026\uffe2\001\002" +
    "\000\016\003\015\012\021\013\012\015\104\025\017\026" +
    "\005\001\002\000\024\002\uffe4\003\uffe4\011\uffe4\012\uffe4" +
    "\013\uffe4\015\uffe4\021\uffe4\025\uffe4\026\uffe4\001\002\000" +
    "\004\002\000\001\002\000\004\012\113\001\002\000\004" +
    "\004\131\001\002\000\004\022\115\001\002\000\004\012" +
    "\117\001\002\000\004\022\123\001\002\000\004\007\120" +
    "\001\002\000\006\010\121\012\122\001\002\000\004\022" +
    "\uffdb\001\002\000\004\022\uffdc\001\002\000\006\010\124" +
    "\012\125\001\002\000\004\020\uffd9\001\002\000\004\020" +
    "\uffda\001\002\000\004\020\127\001\002\000\016\003\015" +
    "\012\021\013\012\015\104\025\017\026\005\001\002\000" +
    "\024\002\uffdf\003\uffdf\011\uffdf\012\uffdf\013\uffdf\015\uffdf" +
    "\021\uffdf\025\uffdf\026\uffdf\001\002\000\006\010\132\012" +
    "\133\001\002\000\004\022\uffdd\001\002\000\004\022\uffde" +
    "\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\131\000\026\002\007\003\005\005\006\006\023\013" +
    "\003\015\021\016\013\021\017\022\015\023\010\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\004\011\066\001\001\000\002\001\001\000" +
    "\002\001\001\000\016\003\005\013\003\015\021\016\013" +
    "\021\026\023\010\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\024\003\005" +
    "\005\006\006\034\013\003\014\033\015\021\016\031\017" +
    "\027\023\010\001\001\000\022\003\005\005\024\013\003" +
    "\015\021\016\013\021\017\022\025\023\010\001\001\000" +
    "\002\001\001\000\016\003\005\013\003\015\021\016\013" +
    "\021\026\023\010\001\001\000\002\001\001\000\014\003" +
    "\005\013\003\015\021\016\036\023\010\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\020\003\005\005\024\013\003\015\021\016\031" +
    "\017\035\023\010\001\001\000\014\003\005\013\003\015" +
    "\021\016\036\023\010\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\010\007\050\010\045\020\046\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\006\010\045" +
    "\020\061\001\001\000\006\010\045\020\054\001\001\000" +
    "\002\001\001\000\004\010\060\001\001\000\004\010\057" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\012" +
    "\007\075\010\045\012\074\020\046\001\001\000\002\001" +
    "\001\000\002\001\001\000\010\007\077\010\045\020\046" +
    "\001\001\000\002\001\001\000\016\003\005\004\101\013" +
    "\003\015\021\016\102\023\010\001\001\000\002\001\001" +
    "\000\002\001\001\000\016\003\005\013\003\015\021\016" +
    "\031\017\104\023\010\001\001\000\014\003\005\013\003" +
    "\015\021\016\036\023\010\001\001\000\002\001\001\000" +
    "\016\003\005\004\107\013\003\015\021\016\102\023\010" +
    "\001\001\000\002\001\001\000\002\001\001\000\004\024" +
    "\113\001\001\000\002\001\001\000\002\001\001\000\004" +
    "\025\115\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\004" +
    "\026\125\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\016\003\005\004\127\013\003\015\021" +
    "\016\102\023\010\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001" });

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
          case 42: // statement ::= LCURLY error RCURLY 
            {
              Object RESULT =null;
		 Logger.get().logDebug("Parser", "Using ERROR rule: statement ::= LCURLY error RCURLY"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 41: // statement ::= error SEMICOLON 
            {
              Object RESULT =null;
		 Logger.get().logDebug("Parser", "Using ERROR rule: statement ::= error SEMICOLON"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 40: // loopafter ::= CONSTANT 
            {
              Object RESULT =null;
		 Logger.get().logDebug("Parser", "Using rule: loopafter ::= CONSTANT"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("loopafter",20, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 39: // loopafter ::= IDENTIFIER 
            {
              Object RESULT =null;
		 Logger.get().logDebug("Parser", "Using rule: loopafter ::= IDENTIFIER"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("loopafter",20, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 38: // loopcheck ::= IDENTIFIER COMPARATOR CONSTANT 
            {
              Object RESULT =null;
		 Logger.get().logDebug("Parser", "Using rule: loopcheck ::= IDENTIFIER COMPARATOR CONSTANT"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("loopcheck",19, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 37: // loopcheck ::= IDENTIFIER COMPARATOR IDENTIFIER 
            {
              Object RESULT =null;
		 Logger.get().logDebug("Parser", "Using rule: loopcheck ::= IDENTIFIER COMPARATOR IDENTIFIER"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("loopcheck",19, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 36: // loopstart ::= IDENTIFIER ASSIGNMENTSYMBOL CONSTANT 
            {
              Object RESULT =null;
		 Logger.get().logDebug("Parser", "Using rule: loopstart ::= IDENTIFIER ASSIGNMENTSYMBOL CONSTANT"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("loopstart",18, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 35: // loopstart ::= IDENTIFIER ASSIGNMENTSYMBOL IDENTIFIER 
            {
              Object RESULT =null;
		 Logger.get().logDebug("Parser", "Using rule: loopstart ::= IDENTIFIER ASSIGNMENTSYMBOL IDENTIFIER"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("loopstart",18, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 34: // loop ::= FOR LBRACKET loopstart SEMICOLON loopcheck SEMICOLON loopafter RBRACKET block 
            {
              Object RESULT =null;
		 Logger.get().logDebug("Parser", "Using rule: loop ::= FOR LBRACKET loopstart SEMICOLON loopcheck SEMICOLON loopafter RBRACKET block"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("loop",17, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-8)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 33: // print ::= PRINT LBRACKET CONSTANT RBRACKET SEMICOLON 
            {
              Object RESULT =null;
		 Logger.get().logDebug("Parser", "Using rule: print ::= PRINT LBRACKET CONSTANT RBRACKET SEMICOLON"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("print",9, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 32: // predicate ::= expresion COMPARATOR expresion 
            {
              Object RESULT =null;
		 Logger.get().logDebug("Parser", "Using rule: predicate ::= expresion COMPARATOR expresion"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("predicate",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 31: // block ::= LCURLY statements RCURLY 
            {
              Object RESULT =null;
		 Logger.get().logDebug("Parser", "Using rule: block ::= LCURLY statements RCURLY"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("block",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 30: // block ::= statement 
            {
              Object RESULT =null;
		 Logger.get().logDebug("Parser", "Using rule: block ::= statement"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("block",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 29: // selection ::= IF LBRACKET predicate RBRACKET block ELSE block 
            {
              Object RESULT =null;
		 Logger.get().logDebug("Parser", "Using rule: selection ::= IF LBRACKET predicate RBRACKET block ELSE block"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("selection",11, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-6)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // factor ::= CONSTANT 
            {
              Object RESULT =null;
		 Logger.get().logDebug("Parser", "Using rule: factor ::= CONSTANT"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("factor",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // factor ::= IDENTIFIER 
            {
              Object RESULT =null;
		 Logger.get().logDebug("Parser", "Using rule: factor ::= IDENTIFIER"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("factor",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // term ::= factor 
            {
              Object RESULT =null;
		 Logger.get().logDebug("Parser", "Using rule: term ::= factor"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("term",14, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // term ::= term BY factor 
            {
              Object RESULT =null;
		 Logger.get().logDebug("Parser", "Using rule: term ::= term BY factor"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("term",14, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // term ::= term TIMES factor 
            {
              Object RESULT =null;
		 Logger.get().logDebug("Parser", "Using rule: term ::= term TIMES factor"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("term",14, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // expresion ::= term 
            {
              Object RESULT =null;
		 Logger.get().logDebug("Parser", "Using rule: expresion ::= term"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expresion",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // expresion ::= expresion MINUS term 
            {
              Object RESULT =null;
		 Logger.get().logDebug("Parser", "Using rule: expresion ::= expresion MINUS term"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expresion",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // expresion ::= expresion PLUS term 
            {
              Object RESULT =null;
		 Logger.get().logDebug("Parser", "Using rule: expresion ::= expresion PLUS term"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expresion",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // assignment ::= IDENTIFIER ASSIGNMENTSYMBOL expresion SEMICOLON 
            {
              Object RESULT =null;
		 Logger.get().logDebug("Parser", "Using rule: assignment ::= IDENTIFIER ASSIGNMENTSYMBOL expresion SEMICOLON"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("assignment",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // statement ::= loop 
            {
              Object RESULT =null;
		 Logger.get().logDebug("Parser", "Using rule: statement ::= loop"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // statement ::= print 
            {
              Object RESULT =null;
		 Logger.get().logDebug("Parser", "Using rule: statement ::= print"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // statement ::= selection 
            {
              Object RESULT =null;
		 Logger.get().logDebug("Parser", "Using rule: statement ::= selection"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // statement ::= assignment 
            {
              Object RESULT =null;
		 Logger.get().logDebug("Parser", "Using rule: statement ::= assignment"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statement",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // identifiers ::= IDENTIFIER 
            {
              Object RESULT =null;
		 Logger.get().logDebug("Parser", "Using rule: identifiers ::= IDENTIFIER"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("identifiers",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // identifiers ::= identifiers COMMA IDENTIFIER 
            {
              Object RESULT =null;
		 Logger.get().logDebug("Parser", "Using rule: identifiers ::= identifiers COMMA IDENTIFIER"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("identifiers",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // statements ::= statement 
            {
              Object RESULT =null;
		 Logger.get().logDebug("Parser", "Using rule: statements ::= statement"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statements",13, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // statements ::= statements statement 
            {
              Object RESULT =null;
		 Logger.get().logDebug("Parser", "Using rule: statements ::= statements statement"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("statements",13, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // scope ::= statements 
            {
              Object RESULT =null;
		 Logger.get().logDebug("Parser", "Using rule: scope ::= statements"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("scope",10, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // scope ::= declarations statements 
            {
              Object RESULT =null;
		 Logger.get().logDebug("Parser", "Using rule: scope ::= declarations statements"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("scope",10, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // firstlevelstatement ::= statement 
            {
              Object RESULT =null;
		 Logger.get().logDebug("Parser", "Using rule: firstlevelstatement ::= statement"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("firstlevelstatement",15, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // firstlevelstatement ::= LCURLY scope RCURLY 
            {
              Object RESULT =null;
		 Logger.get().logDebug("Parser", "Using rule: firstlevelstatement ::= LCURLY scope RCURLY"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("firstlevelstatement",15, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // firstlevelstatements ::= firstlevelstatement 
            {
              Object RESULT =null;
		 Logger.get().logDebug("Parser", "Using rule: firstlevelstatements ::= firstlevelstatement"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("firstlevelstatements",16, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // firstlevelstatements ::= firstlevelstatements firstlevelstatement 
            {
              Object RESULT =null;
		 Logger.get().logDebug("Parser", "Using rule: firstlevelstatements ::= firstlevelstatements firstlevelstatement"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("firstlevelstatements",16, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // declaration ::= TYPE identifiers SEMICOLON 
            {
              Object RESULT =null;
		 Logger.get().logDebug("Parser", "Using rule: declaration ::= TYPE identifiers SEMICOLON"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("declaration",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // declarations ::= declaration 
            {
              Object RESULT =null;
		 Logger.get().logDebug("Parser", "Using rule: declarations ::= declaration"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("declarations",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // declarations ::= declarations declaration 
            {
              Object RESULT =null;
		 Logger.get().logDebug("Parser", "Using rule: declarations ::= declarations declaration"); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("declarations",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // program ::= firstlevelstatements 
            {
              Object RESULT =null;
		 Logger.get().logDebug("Parser", "Using rule: program ::= firstlevelstatements"); 
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
		 Logger.get().logDebug("Parser", "Using rule: program ::= declarations firstlevelstatements"); 
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


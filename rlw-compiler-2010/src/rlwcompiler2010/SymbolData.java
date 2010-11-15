/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rlwcompiler2010;

/**
 *
 * @author je
 */
class SymbolData {

    SymbolData(SymbolData other) {
        this.type = other.type;
        this.constant = other.constant;
    }

    public enum DataType { INT, FLOAT, STRING }

    private DataType type;

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public DataType getType() {
        return type;
    }

    public String printType() {
        try {
        switch(type) {
            case INT:
                return "int";
            case FLOAT:
                return "float";
            case STRING:
                return "string";
        } } catch (NullPointerException e) {return "!!UNTYPED!!";}
        return "";
    }

    public void setType(String s) {
        if (s.equals("int")) setType(DataType.INT);
        if (s.equals("float")) setType(DataType.FLOAT);
        if (s.equals("string")) setType(DataType.STRING);
    }

    public void setType(DataType type) {
        this.type = type;
    }

    public SymbolData() {
    }



/*    class Pos{
        private int i,l;
        Pos(int l,int i){
            this.l=l;
            this.i=i;
        }
        int getLine(){return l;}
        int getLinePos(){return i;}
    }
    SymbolData(){
        occurrence=new Vector<Pos>();
    }
    private Vector<Pos> occurrence;
    void addOccurrence(int l, int index){
        occurrence.add(new Pos(l,index));
    }
 *
 */

    private boolean constant = false;

    public boolean isConstant() {
        return constant;
    }

    public void setConstant() {
        this.constant = true;
    }
}

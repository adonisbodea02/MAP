package Model.Expressions;

import Model.ADTs.MyIDictionary;

public class VarExp extends Exp {

    private String variableName;

    public VarExp(String variableName){
        this.variableName = variableName;
    }

    @Override
    public int evaluate(MyIDictionary<String,Integer> table, MyIDictionary<Integer, Integer> heap) {
        return table.lookup(variableName);
    }

    @Override
    public String toString(){
        return variableName;
    }
}

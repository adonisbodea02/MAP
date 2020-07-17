package Model.Expressions;

import Model.ADTs.MyIDictionary;
import Model.Heap;

public class VarExp extends Exp {

    private String variableName;

    public VarExp(String variableName){
        this.variableName = variableName;
    }

    @Override
    public int evaluate(MyIDictionary<String,Integer> table, Heap heap) {
        return table.lookup(variableName);
    }

    @Override
    public String toString(){
        return variableName;
    }
}

package Model.Expressions;

import Model.ADTs.MyIDictionary;
import Model.Heap;

public class ReadHeapExp extends Exp {

    private String variableName;

    public ReadHeapExp(String variableName){
        this.variableName = variableName;
    }

    @Override
    public String toString(){return "rH(" + variableName + ")";}

    @Override
    public int evaluate(MyIDictionary<String, Integer> table, Heap heap) {
        int id = table.lookup(variableName);
        return(heap.getDict().lookup(id));
    }
}

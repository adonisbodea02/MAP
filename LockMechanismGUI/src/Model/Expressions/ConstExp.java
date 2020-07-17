package Model.Expressions;

import Model.ADTs.MyIDictionary;
import Model.Heap;

public class ConstExp extends Exp {

    private int number;

    public ConstExp(int number){
        this.number = number;
    }

    @Override
    public int evaluate(MyIDictionary<String,Integer> table, Heap heap) {
        return number;
    }

    @Override
    public String toString(){
        return String.valueOf(number);
    }
}

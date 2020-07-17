package Model.Expressions;

import Model.ADTs.MyIDictionary;
import Model.Heap;

public class Greater extends Exp {

    private Exp e1;
    private Exp e2;
    private int order;

    public Greater(Exp e1, Exp e2, int order){
        this.e1 = e1;
        this.e2 = e2;
        this.order = order;
    }

    @Override
    public int evaluate(MyIDictionary<String, Integer> table, Heap heap) {
        if(order == 1)
            if(e1.evaluate(table, heap) > e2.evaluate(table, heap))
                return 1;
            else
                return 0;
        else
            if(e2.evaluate(table, heap) > e1.evaluate(table, heap))
                return 1;
            else
                return 0;
    }

    @Override
    public String toString(){
        if(order == 1)
            return "(" + e1.toString() + ">" + e2.toString() + ")";
        else
            return "(" + e2.toString() + ">" + e1.toString() + ")";
    }
}

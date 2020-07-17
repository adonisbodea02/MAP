package Model.Expressions;

import Model.ADTs.MyIDictionary;

public class NotEqual extends Exp {
    private Exp e1;
    private Exp e2;

    public NotEqual(Exp e1, Exp e2){
        this.e1 = e1;
        this.e2 = e2;
    }

    @Override
    public int evaluate(MyIDictionary<String, Integer> table, MyIDictionary<Integer, Integer> heap) {
        if(e2.evaluate(table, heap) != e1.evaluate(table, heap))
            return 1;
        else
            return 0;
    }


    @Override
    public String toString(){
        return "(" + e1.toString() + "!=" + e2.toString() + ")";
    }
}

package Model.Expressions;

import Exceptions.MyArithmeticException;
import Model.ADTs.MyIDictionary;
import Model.Heap;

public class ArithExp extends Exp {
    private Exp e1;
    private Exp e2;
    private int operator;

    public ArithExp(Exp e1, Exp e2, int operator){
        this.e1 = e1;
        this.e2 = e2;
        this.operator = operator;
    }

    @Override
    public int evaluate(MyIDictionary<String,Integer> table, Heap heap) {
        if(operator == 1)
            return (e1.evaluate(table, heap) + e2.evaluate(table, heap));
        else
            if(operator == 2)
                return (e1.evaluate(table, heap) - e2.evaluate(table, heap));
            else
                if(operator == 3) {
                    if(e2.evaluate(table, heap) != 0)
                        return (e1.evaluate(table, heap) / e2.evaluate(table, heap));
                    else
                        throw new MyArithmeticException();
                }
                else
                    return (e1.evaluate(table, heap) * e2.evaluate(table, heap));
    }

    @Override
    public String toString(){
        if(operator == 1)
            return e1.toString() + "+" + e2.toString();
        else
            if(operator == 2)
                return e1.toString() + "-" + e2.toString();
            else
                if(operator == 3)
                    return e1.toString() + "/" + e2.toString();
                else
                    return e1.toString() + "*" + e2.toString();
    }
}

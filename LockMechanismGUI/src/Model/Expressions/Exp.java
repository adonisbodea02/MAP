package Model.Expressions;

import Model.ADTs.MyIDictionary;
import Model.Heap;

public abstract class Exp {
    public abstract int evaluate(MyIDictionary<String,Integer> table, Heap heap);
}

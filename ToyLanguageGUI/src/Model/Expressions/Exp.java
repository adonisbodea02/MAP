package Model.Expressions;

import Model.ADTs.MyIDictionary;

public abstract class Exp {
    public abstract int evaluate(MyIDictionary<String,Integer> table, MyIDictionary<Integer, Integer> heap);
}

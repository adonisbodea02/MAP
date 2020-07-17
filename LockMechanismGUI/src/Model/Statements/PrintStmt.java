package Model.Statements;

import Model.ADTs.MyIDictionary;
import Model.ADTs.MyIQueue;
import Model.Expressions.Exp;
import Model.Heap;
import Model.PrgState;

public class PrintStmt implements IStmt {

    private Exp expression;

    public PrintStmt(Exp expression){
        this.expression = expression;
    }

    @Override
    public String toString(){return "print(" + expression.toString() + ");";}

    @Override
    public PrgState execute(PrgState state) {
        MyIDictionary<String,Integer> dict = state.getSymTable();
        Heap heap = state.getHeap();
        MyIQueue<Integer> o = state.getOutput();
        int rez = expression.evaluate(dict, heap);
        o.enqueue(rez);
        return null;
    }
}

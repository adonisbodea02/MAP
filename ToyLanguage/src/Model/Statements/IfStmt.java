package Model.Statements;

import Model.ADTs.MyIDictionary;
import Model.ADTs.MyIStack;
import Model.Expressions.Exp;
import Model.PrgState;

public class IfStmt implements IStmt {
    private Exp expression;
    private IStmt thenStmt;
    private IStmt elseStmt;

    public IfStmt(Exp expression, IStmt thenStmt, IStmt elseStmt){
        this.thenStmt = thenStmt;
        this.elseStmt = elseStmt;
        this.expression = expression;
    }

    @Override
    public String toString(){return "IF(" + expression.toString() + ") THEN(" + thenStmt.toString() + ") ELSE("+elseStmt.toString()+")";}

    @Override
    public PrgState execute(PrgState state) {
        MyIStack<IStmt> stk = state.getStack();
        MyIDictionary<String,Integer> table = state.getSymTable();
        MyIDictionary<Integer, Integer> heap = state.getHeap();
        if(expression.evaluate(table, heap) != 0)
            stk.push(thenStmt);
        else
            stk.push(elseStmt);
        return null;
    }
}

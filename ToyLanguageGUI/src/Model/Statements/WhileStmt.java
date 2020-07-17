package Model.Statements;

import Model.ADTs.MyIDictionary;
import Model.ADTs.MyIStack;
import Model.Expressions.Exp;
import Model.PrgState;

public class WhileStmt implements IStmt {

    private IStmt stmt;
    private Exp expression;

    public WhileStmt(IStmt stmt, Exp expression) {
        this.expression = expression;
        this.stmt = stmt;
    }

    public String toString(){
        return "while(" + expression.toString() + ") " + "\r\n{" + stmt.toString() + "}";
    }

    @Override
    public PrgState execute(PrgState state) {
        MyIDictionary<Integer, Integer> heap = state.getHeap();
        MyIDictionary<String, Integer> symTable = state.getSymTable();
        MyIStack<IStmt> stack = state.getStack();
        int value = expression.evaluate(symTable, heap);
        if(value != 0){
            stack.push(this);
            stack.push(stmt);
        }
        return null;
    }
}

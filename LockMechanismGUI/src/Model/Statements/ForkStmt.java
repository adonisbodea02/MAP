package Model.Statements;

import Model.ADTs.MyIDictionary;
import Model.ADTs.MyIStack;
import Model.ADTs.MyStack;
import Model.PrgState;

public class ForkStmt implements IStmt {

    private IStmt stmt;

    public ForkStmt(IStmt stmt){
        this.stmt = stmt;
    }

    @Override
    public String toString() {
        return "fork{" + stmt.toString() + "};";
    }

    @Override
    public PrgState execute(PrgState state) {
        MyIDictionary<String, Integer> newSymTable = state.getSymTable().cloneAll();
        MyIStack<IStmt> newStk = new MyStack<>();
        newStk.push(stmt);
        return new PrgState(newStk, newSymTable, state.getOutput(), state.getFileTable(), state.getHeap(),state.getSemaphore(),state.generateID());
    }
}

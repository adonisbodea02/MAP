package Model.Statements;

import Model.ADTs.MyIStack;
import Model.PrgState;

public class CompStmt implements IStmt {

    private IStmt first;
    private IStmt second;

    public CompStmt(IStmt first, IStmt second){
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString(){return "(" + first.toString() + ";\r\n" + second.toString() + ")";}

    @Override
    public PrgState execute(PrgState state) {
        MyIStack<IStmt> stk = state.getStack();
        stk.push(second);
        stk.push(first);
        return null;
    }
}

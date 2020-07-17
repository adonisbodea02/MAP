package Model.Statements;

import Model.PrgState;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReleaseStmt implements IStmt{

    private static Lock l = new ReentrantLock();
    private String variable;

    public ReleaseStmt(String variable){
        this.variable = variable;
    }

    @Override
    public PrgState execute(PrgState state) {
        l.lock();
        int index = state.getSymTable().lookup(variable);
        if(state.getSemaphore().getDict().isDefined(index)) {
            if(state.getSemaphore().getDict().lookup(index).getPrograms().contains(state.getID())) {
                state.getSemaphore().getDict().lookup(index).getPrograms().removeIf(n->n==state.getID());
            }
        }
        l.unlock();
        return null;
    }

    @Override
    public String toString() {
        return "release(" + variable + ");";
    }
}

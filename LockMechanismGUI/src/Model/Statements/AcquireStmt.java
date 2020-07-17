package Model.Statements;

import Model.PrgState;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AcquireStmt implements IStmt {

    private static Lock l = new ReentrantLock();
    private String variable;

    public AcquireStmt(String variable){
        this.variable = variable;
    }

    @Override
    public PrgState execute(PrgState state) {
        l.lock();
        int index = state.getSymTable().lookup(variable);
        int counter = state.getSemaphore().getDict().lookup(index).getCounter();
        List<Integer> programs = state.getSemaphore().getDict().lookup(index).getPrograms();
        if(counter > programs.size()) {
            if (!programs.contains(state.getID())) {
                state.getSemaphore().getDict().lookup(index).getPrograms().add(state.getID());
            }
        }
        else{
            state.getStack().push(this);
        }
        l.unlock();
        return null;
    }

    @Override
    public String toString() {
        return "acquire(" + variable + ");";
    }
}

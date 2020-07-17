package Model.Statements;

import Model.Expressions.Exp;
import Model.PrgState;
import Model.SemaphorePair;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class newSemaphore implements IStmt{

    private String variable;
    private Exp expression;
    private static Lock l = new ReentrantLock();

    public newSemaphore(String variable, Exp expression){
        this.variable = variable;
        this.expression = expression;
    }

    @Override
    public PrgState execute(PrgState state) {
        l.lock();
        int id = state.getSemaphore().getID();
        int number = expression.evaluate(state.getSymTable(), state.getHeap());
        state.getSemaphore().getDict().add(id, new SemaphorePair(number));
        if(state.getSymTable().isDefined(variable))
            state.getSymTable().update(variable, id);
        else
            state.getSymTable().add(variable, id);
        l.unlock();
        return null;
    }

    @Override
    public String toString() {
        return "newSemaphore(" + variable + "," + expression.toString() + ");";
    }
}

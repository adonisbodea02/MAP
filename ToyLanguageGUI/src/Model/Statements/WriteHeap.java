package Model.Statements;

import Model.ADTs.MyIDictionary;
import Model.Expressions.Exp;
import Model.PrgState;

public class WriteHeap implements IStmt {

    private String variableName;
    private Exp expression;

    public WriteHeap(String variableName, Exp expression){
        this.variableName = variableName;
        this.expression = expression;
    }

    @Override
    public String toString(){return "wH(" + variableName + "," + expression.toString() + ");";}

    @Override
    public PrgState execute(PrgState state) {
        MyIDictionary<Integer, Integer> heap = state.getHeap();
        MyIDictionary<String, Integer> symTable = state.getSymTable();
        int id = symTable.lookup(variableName);
        heap.update(id, expression.evaluate(symTable, heap));
        return null;
    }
}

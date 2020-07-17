package Model.Statements;

import Model.ADTs.MyIDictionary;
import Model.Expressions.Exp;
import Model.HeapIDGenerator;
import Model.PrgState;

public class AllocHeap implements IStmt {

    private String variableName;
    private Exp expression;

    public AllocHeap(String variableName, Exp expression){
        this.variableName = variableName;
        this.expression = expression;
    }

    @Override
    public String toString(){return "new(" + variableName + "," + expression.toString() + ");";}

    @Override
    public PrgState execute(PrgState state) {
        MyIDictionary<Integer, Integer> heap = state.getHeap();
        MyIDictionary<String, Integer> symTable = state.getSymTable();
        int value = expression.evaluate(symTable, heap);
        HeapIDGenerator hidp = new HeapIDGenerator();
        int id = hidp.getID();
        heap.add(id, value);
        if(symTable.isDefined(variableName)) {
            symTable.update(variableName, id);
        }
        else {
            symTable.add(variableName, id);
        }
        return null;
    }
}

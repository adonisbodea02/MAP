package Model.Statements;

import Model.ADTs.MyIDictionary;
import Model.Expressions.Exp;
import Model.Heap;
import Model.PrgState;

public class AssignStmt implements IStmt {

    private String variableName;
    private Exp expression;

    public AssignStmt(String variable_name, Exp expression){
        this.expression = expression;
        this.variableName = variable_name;
    }

    @Override
    public String toString(){return variableName + "=" + expression.toString() + ";";}

    @Override
    public PrgState execute(PrgState state) {
        MyIDictionary<String,Integer> table = state.getSymTable();
        Heap heap = state.getHeap();
        int rez = expression.evaluate(table, heap);
        if(table.isDefined(variableName))
            table.update(variableName, rez);
        else
            table.add(variableName, rez);
        return null;
    }
}

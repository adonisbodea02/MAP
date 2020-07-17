package Model.Statements;

import Model.ADTs.MyIDictionary;
import Model.Expressions.Exp;
import Model.FileTuple;
import Model.Heap;
import Model.PrgState;

import java.io.IOException;

public class ReadFile implements IStmt {
    private Exp expression;
    private String variableName;

    public ReadFile(Exp expression, String variableName){
        this.expression = expression;
        this.variableName = variableName;
    }

    @Override
    public String toString(){return "read(" + expression.toString() + "," + variableName +");";}

    @Override
    public PrgState execute(PrgState state) {
        MyIDictionary<Integer, FileTuple> fileTable = state.getFileTable();
        MyIDictionary<String, Integer> symTable = state.getSymTable();
        Heap heap = state.getHeap();
        Integer id = expression.evaluate(symTable, heap);
        FileTuple tp = fileTable.lookup(id);
        try {
            String message = tp.getFileDescriptor().readLine();
            Integer value = Integer.parseInt(message);
            if(symTable.isDefined(variableName))
                symTable.update(variableName, value);
            else
                symTable.add(variableName, value);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

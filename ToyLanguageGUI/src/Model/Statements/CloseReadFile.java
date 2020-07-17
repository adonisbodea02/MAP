package Model.Statements;

import Model.ADTs.MyIDictionary;
import Model.Expressions.Exp;
import Model.FileTuple;
import Model.PrgState;

import java.io.BufferedReader;
import java.io.IOException;

public class CloseReadFile implements IStmt {

    private Exp expression;

    public CloseReadFile(Exp expression){
        this.expression = expression;
    }

    @Override
    public String toString(){return "close(" + expression.toString() + ");";}

    @Override
    public PrgState execute(PrgState state) {
        MyIDictionary<Integer, FileTuple> fileTable = state.getFileTable();
        MyIDictionary<Integer, Integer> heap = state.getHeap();
        MyIDictionary<String, Integer> symTable = state.getSymTable();
        Integer id = expression.evaluate(symTable, heap);
        BufferedReader bf = fileTable.lookup(id).getFileDescriptor();
        try {
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileTable.remove(id);
        return null;
    }
}

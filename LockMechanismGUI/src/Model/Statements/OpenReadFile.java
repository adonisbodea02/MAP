package Model.Statements;

import Exceptions.MyOpenReadFileException;
import Model.ADTs.MyIDictionary;
import Model.FileTuple;
import Model.PrgState;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collection;

public class OpenReadFile implements IStmt{

    private String filename;
    private String variableName;

    public OpenReadFile(String filename, String variableName){
        this.filename = filename;
        this.variableName = variableName;
    }

    @Override
    public String toString(){return "open(" + filename + "," + variableName + ");";}

    @Override
    public PrgState execute(PrgState state) {
        MyIDictionary<Integer, FileTuple> fileTable = state.getFileTable();
        MyIDictionary<String, Integer> symTable = state.getSymTable();
        Collection<FileTuple> tuples = fileTable.getValues();
        for (FileTuple p: tuples) {
            if(p.getFilename().equals(filename))
                throw new MyOpenReadFileException();
        }
        try {
            BufferedReader newReader = new BufferedReader(new FileReader(filename));
            FileTuple ft = new FileTuple(filename, newReader);
            Integer id = ft.getIndex();
            fileTable.add(id, ft);
            if(symTable.isDefined(variableName))
                symTable.update(variableName, id);
            else
                symTable.add(variableName, id);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

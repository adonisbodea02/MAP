package Model;

import Exceptions.MyStmtExecException;
import Model.ADTs.MyIDictionary;
import Model.ADTs.MyIQueue;
import Model.ADTs.MyIStack;
import Model.Statements.IStmt;

public class PrgState {
    private MyIStack<IStmt> exeStack;
    private MyIDictionary<String, Integer> symTable;
    private MyIQueue<Integer> out;
    private MyIDictionary<Integer, FileTuple> fileTable;
    private MyIDictionary<Integer, Integer> heap;
    // private AtomicInteger ID;
    private int ID;

    public PrgState(MyIStack<IStmt> stk, MyIDictionary<String, Integer> symTable, MyIQueue<Integer> out, MyIDictionary<Integer, FileTuple> fileTable, MyIDictionary<Integer, Integer> heap, Integer ID){
        exeStack = stk;
        this.symTable = symTable;
        this.out = out;
        this.fileTable = fileTable;
        this.heap = heap;
        this.ID = ID;
    }

    public boolean isCompleted(){
        return exeStack.isEmpty();
    }

    public MyIStack<IStmt> getStack(){return exeStack;}
    public MyIDictionary<String, Integer> getSymTable(){return symTable;}
    public MyIQueue<Integer> getOutput() {return out;}
    public MyIDictionary<Integer, FileTuple> getFileTable() {return fileTable;}
    public MyIDictionary<Integer, Integer> getHeap() {return heap;}
    public int getID(){return ID;}

    //public void setExeStack(MyIStack<IStmt> stack){this.exeStack = stack;}
    //public void setSymTable(MyIDictionary<String, Integer> dict) {this.symTable = dict;}
    //public void setOut(MyIQueue<Integer> queue) {this.out = queue;}

    public PrgState oneStep(){
        if(exeStack.isEmpty())
            throw new MyStmtExecException();
        IStmt current = exeStack.pop();
        return current.execute(this);
    }

    @Override
    public String toString(){
        return  "ID: n " + ID + ";\n" +
                "Execution Stack:\n " + exeStack.toString() + ";\n" +
                "Symbol Table:\n " + symTable.toString() + ";\n" +
                "Output Queue:\n " + out.toString() + ";\n" +
                "File Table:\n " + fileTable.toString() + ";\n" +
                "Heap:\n " + heap.toString() + ";\n";
    }
}

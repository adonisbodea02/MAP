package Model;

import Exceptions.MyStmtExecException;
import Model.ADTs.MyIDictionary;
import Model.ADTs.MyIQueue;
import Model.ADTs.MyIStack;
import Model.Statements.IStmt;

import java.util.concurrent.atomic.AtomicInteger;

public class PrgState {
    private MyIStack<IStmt> exeStack;
    private MyIDictionary<String, Integer> symTable;
    private MyIQueue<Integer> out;
    private MyIDictionary<Integer, FileTuple> fileTable;
    private Heap heap;
    private Semaphore sem;
    private static AtomicInteger generator = new AtomicInteger(1);
    private int ID;

    public PrgState(MyIStack<IStmt> stk, MyIDictionary<String, Integer> symTable, MyIQueue<Integer> out, MyIDictionary<Integer, FileTuple> fileTable, Heap heap, Semaphore sem, Integer ID){
        exeStack = stk;
        this.symTable = symTable;
        this.out = out;
        this.fileTable = fileTable;
        this.heap = heap;
        this.ID = ID;
        this.sem = sem;
    }

    public boolean isCompleted(){
        return exeStack.isEmpty();
    }

    public MyIStack<IStmt> getStack(){return exeStack;}
    public MyIDictionary<String, Integer> getSymTable(){return symTable;}
    public MyIQueue<Integer> getOutput() {return out;}
    public MyIDictionary<Integer, FileTuple> getFileTable() {return fileTable;}
    public Heap getHeap() {return heap;}
    public Semaphore getSemaphore() {return sem;}
    public int getID(){return ID;}
    public int generateID(){return generator.addAndGet(1);}

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
        return  "Program State " + ID;
    }
}

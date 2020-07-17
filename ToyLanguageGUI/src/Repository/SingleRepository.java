package Repository;

import Model.ADTs.MyIDictionary;
import Model.ADTs.MyIStack;
import Model.ADTs.MyStack;
import Model.FileTuple;
import Model.PrgState;
import Model.Statements.IStmt;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SingleRepository implements Repository{

    private List<PrgState> states;
    private String filename;

    public SingleRepository(PrgState program, String filename){
        this.filename = filename;
        this.states = new ArrayList<>();
        states.add(program);
    }

    @Override
    public List<PrgState> getPrgList() {
        return states;
    }

    @Override
    public void setPrgList(List<PrgState> states) {
        this.states = states;
    }

    @Override
    public void logPrgStateExec(PrgState state){
        try {
            PrintWriter logFile = new PrintWriter(new BufferedWriter(new FileWriter(this.filename,true)));
            logFile.append("New log: ");
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS");
            LocalDateTime now = LocalDateTime.now();
            logFile.append(dtf.format(now));
            logFile.append("\r\n");
            logFile.append("Thread ID: ");
            logFile.append(String.valueOf(state.getID()));
            logFile.append("\r\n");
            logFile.append("ExeStack: \r\n");
            MyIStack<IStmt> stack = state.getStack();
            MyIStack<IStmt> stack2 = new MyStack<>();
            while(!stack.isEmpty()){
                IStmt stmt = stack.pop();
                logFile.append(stmt.toString());
                logFile.append("\r\n");
                stack2.push(stmt);
            }
            while(!stack2.isEmpty()){
                stack.push(stack2.pop());
            }

            logFile.append("SymTable:\r\n");
            MyIDictionary<String, Integer> dict = state.getSymTable();
            Set<String> keys = dict.getKeys();
            for (String key: keys) {
                logFile.append(key);
                logFile.append("->");
                logFile.append(dict.lookup(key).toString());
                logFile.append("\r\n");
            }

            logFile.append("Out:\r\n");
            Object[] elems = state.getOutput().getElements();
            for (Object a: elems) {
                logFile.append(a.toString());
                logFile.append("\r\n");
            }

            logFile.append("FileTable:\r\n");
            MyIDictionary<Integer, FileTuple> table = state.getFileTable();
            Set<Integer> ints = table.getKeys();
            for (Integer key: ints) {
                logFile.append(key.toString());
                logFile.append("->");
                logFile.append(table.lookup(key).toString());
                logFile.append("\r\n");
            }

            logFile.append("Heap:\r\n");
            MyIDictionary<Integer, Integer> heap = state.getHeap();
            Set<Integer> heaps = heap.getKeys();
            for (Integer key: heaps) {
                logFile.append(key.toString());
                logFile.append("->");
                logFile.append(heap.lookup(key).toString());
                logFile.append("\r\n");
            }
            logFile.append("\r\n");
            logFile.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

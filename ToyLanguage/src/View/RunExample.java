package View;

import Controller.Ctrl;
import Exceptions.*;
import Model.HeapIDGenerator;

public class RunExample extends Command {

    private Ctrl c;
    RunExample(String key, String desc, Ctrl c){
        super(key, desc);
        this.c = c;
    }

    @Override
    public void execute() {
        try{
            HeapIDGenerator hidp = new HeapIDGenerator();
            hidp.resetGenerator();
            c.allSteps();
        }
        catch (MyDictionaryException | MyQueueException | MyStackException | MyArithmeticException | MyStmtExecException |MyOpenReadFileException e){
            System.out.println(e.getMessage());
        }
    }
}

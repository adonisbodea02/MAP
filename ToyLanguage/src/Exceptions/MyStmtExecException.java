package Exceptions;

public class MyStmtExecException extends RuntimeException{
    public MyStmtExecException(){
        super("Program is finished!\n");
    }
}

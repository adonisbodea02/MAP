package Exceptions;

public class MyStackException extends RuntimeException {
    public MyStackException(){
        super("Stack is empty!\n");
    }
}

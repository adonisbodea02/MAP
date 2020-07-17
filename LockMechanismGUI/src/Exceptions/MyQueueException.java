package Exceptions;

public class MyQueueException extends RuntimeException {
    public MyQueueException(){
        super("Queue is empty!\n");
    }
}

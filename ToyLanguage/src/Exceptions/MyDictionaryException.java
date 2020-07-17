package Exceptions;

public class MyDictionaryException extends RuntimeException{
    public MyDictionaryException(){
        super("Value not defined!\n");
    }
}

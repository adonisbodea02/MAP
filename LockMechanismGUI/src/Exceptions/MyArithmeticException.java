package Exceptions;

public class MyArithmeticException extends RuntimeException{
    public MyArithmeticException(){
        super("Division by zero!\n");
    }
}

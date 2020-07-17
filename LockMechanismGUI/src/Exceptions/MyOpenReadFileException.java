package Exceptions;

public class MyOpenReadFileException extends RuntimeException{
    public MyOpenReadFileException(){
        super("The name of the file already exists in the file table!\n");
    }
}

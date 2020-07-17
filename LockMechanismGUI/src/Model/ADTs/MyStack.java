package Model.ADTs;
import Exceptions.MyStackException;

import java.util.Stack;

public class MyStack<T> implements MyIStack<T> {
    private Stack<T> st;

    public MyStack(){ this.st = new Stack<>(); }

    @Override
    public void push(T v){
        st.push(v);
    }

    @Override
    public T pop(){
        if(!isEmpty())
            return st.pop();
        else
            throw new MyStackException();
    }

    @Override
    public boolean isEmpty(){
        return st.empty();
    }

    @Override
    public T top(){
        if(!isEmpty())
            return st.peek();
        else
            throw new MyStackException();
    }

    @Override
    public String toString(){
        return st.toString();
    }
}

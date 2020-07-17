package Model.ADTs;
import Exceptions.MyQueueException;

import java.util.LinkedList;

public class MyQueue<T> implements MyIQueue<T> {

    private LinkedList<T> q;

    public MyQueue(){ this.q = new LinkedList<>(); }

    @Override
    public void enqueue(T value) {
        q.add(q.size(), value);
    }

    @Override
    public T deque() {
        if(isEmpty())
            throw new MyQueueException();
        else
            return q.remove();
    }

    @Override
    public boolean isEmpty() {
        return q.size() == 0;
    }

    @Override
    public T top() {
        if(!isEmpty())
            return q.peek();
        else
            throw new MyQueueException();
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        Object[] list = q.toArray();
        for (Object aList : list){
            s.append(aList.toString());
            s.append(" ");
        }
        return s.toString();
    }

    @Override
    public Object[] getElements(){
        return q.toArray();
    }
}

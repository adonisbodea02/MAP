package Model.ADTs;

public interface MyIStack<T> {

    void push(T v);
    T pop();
    boolean isEmpty();
    T top();
}

package Model.ADTs;

public interface MyIQueue<T> {
    void enqueue(T value);
    T deque();
    boolean isEmpty();
    T top();
    Object[] getElements();
}

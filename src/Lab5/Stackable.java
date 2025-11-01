package Lab5;

public interface Stackable <T>{
    void push(T item);
    T pop() throws IllegalStateException;
    T peek() throws IllegalStateException;
    boolean isEmpty();
    void print();
}

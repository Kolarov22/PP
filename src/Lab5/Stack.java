package Lab5;

import java.util.LinkedList;

public class Stack <T> implements Stackable<T> {
    private LinkedList<T> items;

    public Stack() {
        this.items = new LinkedList<T>();
    }

    public void push(T item) {
        items.addLast(item);
    }

    public T pop(){
        if ( items.isEmpty() ){
            throw new IllegalStateException("Stack is empty");
        }

        return items.removeLast();
    }

    public T peek(){
        if ( items.isEmpty() ){
            throw new IllegalStateException("Stack is empty");
        }

        return items.getLast();
    }

    public void print(){
        for ( T item : items.reversed() ){
            System.out.print(item + " ");
        }
    }

    public boolean isEmpty(){
        return items.isEmpty();
    }
}

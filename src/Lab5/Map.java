package Lab5;


import java.util.LinkedList;

public interface Map <K, V>{
    void add(K key, V value);
    V remove(K key);
    boolean isEmpty();
    LinkedList<K> keys();
    void print();
    int size();
}

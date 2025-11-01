package Lab5;

import java.util.LinkedList;

public class MapImpl <K, V> implements Map<K, V> {
    private LinkedList<K> keys;
    private LinkedList<V> values;

    public MapImpl() {
        this.keys = new LinkedList<K>();
        this.values = new LinkedList<V>();
    }


    @Override
    public void add(K key, V value) {
        if (!keys.contains(key)) {
            keys.add(key);
            values.add(value);
        }
        else{
            int index = keys.indexOf(key);
            values.set(index, value);
        }

    }

    @Override
    public V remove(K key) {
        int index = keys.indexOf(key);
        if (index != -1) {
            keys.remove(index);
            return values.remove(index);
        }

        throw new IllegalStateException("Key not found");
    }

    @Override
    public boolean isEmpty() {
        return keys.isEmpty();
    }

    @Override
    public LinkedList<K> keys() {
        return keys;
    }

    @Override
    public void print() {
        for (int i = 0; i < keys.size(); i++) {
            System.out.println(keys.get(i) + " : " + values.get(i));
        }
    }

    @Override
    public int size(){
        return keys.size();
    }
}

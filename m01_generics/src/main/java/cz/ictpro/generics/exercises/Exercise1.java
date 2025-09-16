package cz.ictpro.generics.exercises;

/*
Task 1
Create the Pair class which, based on generic types, will allow to store any pair
of objects.
 */

public class Exercise1 {
    public static void main(String[] args) {
        Pair<Integer, String> pair = new Pair<>(23,
                "JavaAdvanced");
        System.out.println(pair);
    }
}

class Pair<K, V> {
    private K key;
    private V value;
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public K getKey() {
        return key;
    }
    public void setKey(K key) {
        this.key = key;
    }
    public V getValue() {
        return value;
    }
    public void setValue(V value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return "Pair{" +
               "key=" + key +
               ", value=" + value +
               '}';
    }
}

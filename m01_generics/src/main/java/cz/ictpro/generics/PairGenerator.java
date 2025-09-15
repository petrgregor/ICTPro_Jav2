package cz.ictpro.generics;

public class PairGenerator {
    public static <K, V> Pair<K, V> generatePair(K key, V value) {
        Pair<K, V> pair = new Pair<K, V>();
        pair.setKey(key);
        pair.setValue(value);
        return pair;
    }
}
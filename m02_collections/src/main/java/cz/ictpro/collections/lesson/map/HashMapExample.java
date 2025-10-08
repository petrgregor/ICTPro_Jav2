package cz.ictpro.collections.lesson.map;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        final Map<Integer, String> ageToNames = new HashMap<>(); //  HashMapy
        ageToNames.put(11, "Andrew"); // adding items
        ageToNames.put(22, "Michael");  // adding another pair
        ageToNames.put(33, "John");  // adding a third pair to the map
        ageToNames.remove(22);     // removing an item based on the key
        ageToNames.put(11, "Peter");  // replace Andrew with Peter
        System.out.println(ageToNames.get(11)); // displaying the value based on the key 11 -> Andrew

        System.out.println(ageToNames.keySet());
        System.out.println(ageToNames.values());
        System.out.println(ageToNames.isEmpty());
        System.out.println(ageToNames.size());
        System.out.println(ageToNames.entrySet());
    }
}

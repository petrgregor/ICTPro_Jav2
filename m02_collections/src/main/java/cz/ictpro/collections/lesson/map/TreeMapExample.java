package cz.ictpro.collections.lesson.map;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        final Map<Integer, Integer> numberToDigitsSum = new TreeMap<>();
        numberToDigitsSum.put(33, 6);
        numberToDigitsSum.put(19, 10);
        numberToDigitsSum.put(24, 6);
        numberToDigitsSum.forEach((key, value) -> System.out.println(key + " " + value));

        /* Items will always be listed in the same order:
          19 10
          24 6
          33 6
        */
    }
}

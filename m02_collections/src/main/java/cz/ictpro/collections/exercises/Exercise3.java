package cz.ictpro.collections.exercises;

import java.util.*;

public class Exercise3 {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            values.add(random.nextInt(50));
        }
        Set<Integer> uniqueValues = new HashSet<>();
        Set<Integer> duplicatedValues = new HashSet<>();
        for (Integer value : values) {
            if (!uniqueValues.add(value)) {
                duplicatedValues.add(value);
            }
        }
        System.out.println("Unique: " + uniqueValues);
        System.out.println("Duplicated: " + duplicatedValues);
    }
}

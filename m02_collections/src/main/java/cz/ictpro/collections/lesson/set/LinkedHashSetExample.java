package cz.ictpro.collections.lesson.set;

import java.util.Set;
import java.util.LinkedHashSet;

public class LinkedHashSetExample {

    public static void main(String[] args) {
        final Set<Integer> numbersSet = new LinkedHashSet<>();
        numbersSet.add(1);
        numbersSet.add(3);
        numbersSet.add(2);
        numbersSet.add(1); // Adding an item with a value that already exists - the item is NOT added again
        numbersSet.forEach (System.out::println);
        /* The order of items will ALWAYS be the same (in the order of adding items)
         1 3 2
        */
    }
}

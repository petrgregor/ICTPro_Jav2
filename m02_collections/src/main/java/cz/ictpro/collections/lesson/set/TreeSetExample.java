package cz.ictpro.collections.lesson.set;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        final Set<Integer> numbersSet = new TreeSet<>();
        numbersSet.add(1);
        numbersSet.add(3);
        numbersSet.add(2);
        numbersSet.add(1); // Adding an item with a value that already exists - the item is NOT added again
        numbersSet.forEach (System.out::println);
        /* The order of the items will ALWAYS be the same (sorted in natural order):
         1 2 3
        */

    }
}

package cz.ictpro.collections.lesson.set;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        final Set<Integer> numbersSet = new HashSet<>(); // creating HashSet
        System.out.println(numbersSet.isEmpty()); // true, Set does not contain elements
        numbersSet.add(1);
        numbersSet.add(17);
        numbersSet.add(3);
        numbersSet.add(2);
        numbersSet.add(1); // Adding an item with a value that already exists - the item is NOT added again
        numbersSet.forEach(System.out::println);

        /* example order in which items can be listed:
         1 17 2 3
        */

    }
}

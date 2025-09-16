package cz.ictpro.collections.lesson.list;

import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {
    public static void main(String[] args) {
        final List<String> names = new LinkedList<>();
        names.add(0, "Andrew");  // adding an item to the top of the list
        names.add(0, "Gregory"); // adding an item to the top of the list
        for (final String name: names) {
            System.out.println(name); // Gregory, Andrew will be printed on the screen in order
        }
    }
}

package cz.ictpro.collections.lesson.list;

import java.util.List;
import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        final List<String> names = new ArrayList<>();
        names.add("Andrew");  // adding an item to the end of the list
        names.add("Gregory"); // adding an item to the end of the list
        for (final String name: names) {
            System.out.println(name); // Andrew, Gregory will be displayed on the screen, keeping the order
        }
    }
}

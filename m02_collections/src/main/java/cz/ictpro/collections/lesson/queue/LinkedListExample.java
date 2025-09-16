package cz.ictpro.collections.lesson.queue;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedListExample {
    public static void main(String[] args) {
        final Queue<String> events = new LinkedList<>();
        events.offer("ButtonClicked");
        events.offer("MouseMoved");
        System.out.println(events.peek());   // displaying the first element
        System.out.println(events.poll());   // removing the first item from the queue and returning a value
        System.out.println(events.poll());   // removing the first item from the queue again and returning the value
        System.out.println(events.isEmpty()); // at this point the queue is empty
    }
}

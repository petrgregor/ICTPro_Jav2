package cz.ictpro.collections.lesson.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeExample {
    public static void main(String[] args) {
        // create a Deque object
        final Deque<Integer> deque = new ArrayDeque<>();
        // add elements to deque
        deque.offerLast(2);
        deque.offerFirst(1);
        System.out.println (deque.pollLast()); // remove elements from deque along with removing from structure -> 2
        System.out.println (deque.peekLast()); // remove elements from deque without removing them from structure -> 1
    }
}

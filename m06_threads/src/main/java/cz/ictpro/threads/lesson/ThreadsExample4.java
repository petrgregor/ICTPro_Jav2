package cz.ictpro.threads.lesson;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThreadsExample4 {
    public static void main(String[] args) {
        final Thread sleepingThread = new Thread(new SleepingThread1());
        sleepingThread.start();
        sleepingThread.interrupt();
    }
}

class SleepingThread1 implements Runnable {

    @Override
    public void run() {
        final List<Integer> ints = new ArrayList<>();
        for (int idx = 0; idx < 1000; idx++) {
            ints.add(new Random().nextInt());
        }
        if (Thread.currentThread().isInterrupted()) { // or resetting the status of Thread.interrupted()
            System.out.println("I was interrupted...");
            return;
        }
        final int sum = ints.stream().mapToInt(value -> value).sum();
        System.out.println("Sum is " + sum);
    }
}


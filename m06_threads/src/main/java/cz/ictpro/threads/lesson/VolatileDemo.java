package cz.ictpro.threads.lesson;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VolatileDemo {

    public static volatile boolean shouldStop = false;

    public static void main(String[] args) throws InterruptedException {
        final ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(new VolatileThread());
        while (!shouldStop) {
            Thread.sleep(100L);
            System.out.println("Waiting for signal to stop checking that volatile boolean");
        }
        executorService.shutdown();
    }
}

class VolatileThread implements Runnable {

    @Override
    public void run() {
        System.out.println("Starting some processing");
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            System.err.println("Oops");
        }
        System.out.println("Processing finished");
        VolatileDemo.shouldStop = true;
    }
}


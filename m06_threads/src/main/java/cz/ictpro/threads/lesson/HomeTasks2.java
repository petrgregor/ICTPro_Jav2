package cz.ictpro.threads.lesson;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class HomeTasks2 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Callable<String>> tasks = Arrays.asList(
                () -> {
                    System.out.println("Thread: " + Thread.currentThread().getName());
                    System.out.println("I'm shopping");
                    Thread.sleep(5000);
                    System.out.println("Thread: " + Thread.currentThread().getName() + ". Shopping done!");
                    return "Shopping done!";
                },
                () -> {
                    System.out.println("Thread: " + Thread.currentThread().getName());
                    System.out.println("Washing dishes");
                    Thread.sleep(2000);
                    System.out.println("Thread: " + Thread.currentThread().getName() + ". Dishes washed");
                    return "Dishes washed";
                },
                () -> {
                    System.out.println("Thread: " + Thread.currentThread().getName());
                    System.out.println("Cleaning the room");
                    Thread.sleep(1000);
                    System.out.println("Thread: " + Thread.currentThread().getName() + ". Room cleaned");
                    return "Room cleaned";
                }
        );
        try {
            List<Future<String>> futures = executorService.invokeAll(tasks);
            for (Future<String> future : futures) {
                System.out.println(future.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}


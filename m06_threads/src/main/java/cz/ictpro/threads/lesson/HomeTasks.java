package cz.ictpro.threads.lesson;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HomeTasks {
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
                    return "dishes washed";
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
            String firstResult = executorService.invokeAny(tasks);
            System.out.println("FIRST RESULT: " + firstResult);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}

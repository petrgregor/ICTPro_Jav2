package cz.ictpro.threads.lesson;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFutureExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor(); // creating an ExecutorService with a single-threaded pool
        Future<String> result = executorService.submit(() -> "I am result of callable!"); // Callable implementation using lambda
        try {
            System.out.println("Print result of the future: " + result.get());
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Oops");
        }
        executorService.shutdown(); // remember to close the ExecutorService manually
    }
}


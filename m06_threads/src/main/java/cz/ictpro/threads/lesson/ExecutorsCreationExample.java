package cz.ictpro.threads.lesson;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ExecutorsCreationExample {
    public static void main(String[] args) throws InterruptedException {
        final int cpus = Runtime.getRuntime().availableProcessors();
        final ExecutorService singleThreadES = Executors.newSingleThreadExecutor(); // single thread pool
        final ExecutorService executorService = Executors.newFixedThreadPool(cpus); // pool with threads equal to cpu
        final ExecutorService cachedES = Executors.newCachedThreadPool();           // cached thread pool
        final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(cpus); // scheduled thread pool with cpu equal number of threads
    }
}


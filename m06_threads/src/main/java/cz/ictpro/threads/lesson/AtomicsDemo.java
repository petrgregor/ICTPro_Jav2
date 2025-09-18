package cz.ictpro.threads.lesson;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicsDemo {
    public static void main(String[] args) {
        final ExecutorService executorService = Executors.newFixedThreadPool(2);
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        executorService.submit(new IncrementingThread(atomicInteger));
        executorService.submit(new IncrementingThread(atomicInteger));
        executorService.shutdown();
    }
}

class IncrementingThread implements Runnable {

    private final AtomicInteger value;

    IncrementingThread(final AtomicInteger value) {
        this.value = value;
    }

    @Override
    public void run() {
        for (int idx = 0; idx < 1000; idx++) {
            value.incrementAndGet();
        }
        System.out.println(value.get()); // the slower thread will always print 2000
    }
}


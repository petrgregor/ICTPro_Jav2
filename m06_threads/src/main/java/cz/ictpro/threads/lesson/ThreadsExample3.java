package cz.ictpro.threads.lesson;

public class ThreadsExample3 {
    public static void main(String[] args) {
        final Thread sleepingThread = new Thread(new SleepingThread());
        sleepingThread.start();
        sleepingThread.interrupt(); // sending a stop request
    }
}

class SleepingThread implements Runnable {

    @Override
    public void run() {
        System.out.println("I will go to sleep");
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) { // catching an InterruptedException if an interrupt signal was sent while the sleep method is executing
            System.out.println("I was interrupted during sleep");
        }
        System.out.println("I am exiting");
    }
}


package cz.ictpro.threads.lesson;

public class ThreadsExample1 {
    public static void main(String[] args) {
        new HelloWorldThread().start();
        System.out.println(Thread.currentThread().getId());
    }
}

/*
NOTE: Inheriting from Thread is NOT RECOMMENDED. If you want to create a new thread, let's use the Runnable interface.
 */
class HelloWorldThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello World from another Thread");
        System.out.println(Thread.currentThread().getId());
    }
}

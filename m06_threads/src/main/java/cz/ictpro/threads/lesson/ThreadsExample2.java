package cz.ictpro.threads.lesson;

public class ThreadsExample2 {
    public static void main(String[] args) {
        new Thread(new HelloWorldRunnableThread()).start();
        new Thread(() -> System.out.println("Hello from another thread implemented with lambda")).start();
    }
}

class HelloWorldRunnableThread implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello World from another Thread");
    }
}

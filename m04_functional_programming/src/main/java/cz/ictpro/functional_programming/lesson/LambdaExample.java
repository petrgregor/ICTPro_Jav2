package cz.ictpro.functional_programming.lesson;

public class LambdaExample {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Implementation of the Runnable interface as an implementation of an anonymous class!");
            }
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            System.out.println("Runnable example using lambda!");
        });
        thread2.start();

    }

}

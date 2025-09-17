package cz.ictpro.functional_programming.lesson;

public class LambdaExample2 {
    public static void main(String[] args) {

        Runnable runnableExample = () -> {
            System.out.println("Hello from runnable");
            System.out.println("{ and } cannot be omitted");
        };
        runnableExample.run();

    }

    @FunctionalInterface
    public interface Runnable {
        public abstract void run();
    }

}

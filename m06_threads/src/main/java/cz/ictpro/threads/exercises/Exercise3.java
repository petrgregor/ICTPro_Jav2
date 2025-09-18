package cz.ictpro.threads.exercises;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exercise3 {
    public static void main(String[] args) throws
            InterruptedException, ExecutionException {
        Random random = new Random();
        int[] array1 = new int[10000];
        int[] array2 = new int[10000];
        for (int i = 0; i < 10000; i++) {
            array1[i] = random.nextInt(20000);
            array2[i] = array1[i];
        }
        ExecutorService executorService =
                Executors.newFixedThreadPool(2);
        String result = executorService.invokeAny(Arrays.asList(
                new BubbleSortStrategy(array1),
                new InsertionSortStrategy(array2)
        ));
        System.out.println(result);
        executorService.shutdown();
    }
}
class BubbleSortStrategy implements Callable<String> {
    private int[] array;
    public BubbleSortStrategy(int[] array) {
        this.array = array;
    }
    public void bubbleSort() {
        boolean sorted = false;
        int temp;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    sorted = false;
                }
            }
        }
    }
    @Override
    public String call() throws Exception {
        bubbleSort();
        return "Bubble sort";
    }
}
class InsertionSortStrategy implements Callable<String> {
    private int[] array;
    public InsertionSortStrategy(int[] array) {
        this.array = array;
    }
    public void insertionSort() {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && current < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
    }
    @Override
    public String call() throws Exception {
        insertionSort();
        return "Insertion sort";
    }
}
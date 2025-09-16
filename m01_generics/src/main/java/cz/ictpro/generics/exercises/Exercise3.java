package cz.ictpro.generics.exercises;

/*
Task 3
Design the generic swap method, which will be responsible for swapping the
position of the selected elements of the array.
 */

import java.util.Arrays;

public class Exercise3 {
    public static void main(String[] args) {
        Integer[] tab = {10, 21, 33, 40, 50, 60};
        ArrayUtils.swap(tab, 2, 5);
        System.out.println(Arrays.toString(tab));
    }
}

class ArrayUtils {
    public static <T> void swap(T[] array, int index1, int index2)
    {
        T tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }
}

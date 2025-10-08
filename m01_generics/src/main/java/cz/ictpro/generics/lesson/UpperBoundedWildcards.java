package cz.ictpro.generics.lesson;

import java.util.List;

public class UpperBoundedWildcards {

    public static double sum(final List<? extends Number> numbers) { // the method accepts only types extending the Number class
        double sum = 0;
        for (Number number : numbers) {
            sum += number.doubleValue();
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> values = List.of(1, 2, 3);
        System.out.println(sum(values));

        List<Double> doubles = List.of(1.5, 3.7, 15.8);
        System.out.println(sum(doubles));
    }
}

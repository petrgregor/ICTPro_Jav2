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
}

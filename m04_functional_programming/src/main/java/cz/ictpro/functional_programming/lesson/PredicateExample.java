package cz.ictpro.functional_programming.lesson;

import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        Predicate<Integer> predicate = (value) -> {
            return value >= 0;
        };
        checkTest(predicate);
    }

    static void checkTest(Predicate<Integer> predicate) {
        System.out.println(predicate.test(-1));
    }
}


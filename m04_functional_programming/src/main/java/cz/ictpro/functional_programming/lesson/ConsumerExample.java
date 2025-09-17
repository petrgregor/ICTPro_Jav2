package cz.ictpro.functional_programming.lesson;

import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        Consumer<String> stringTrim = (s) -> {
            s = s.trim();
            System.out.println(s);
        }; // Consumer implementation using multi-line lambda

        trimValue(stringTrim, "   text    ");
    }

    static void trimValue(Consumer<String> trimAction, String s) {
        trimAction.accept(s);
    }
}

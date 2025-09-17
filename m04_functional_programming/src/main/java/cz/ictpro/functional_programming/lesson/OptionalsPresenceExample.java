package cz.ictpro.functional_programming.lesson;

import java.util.Optional;

public class OptionalsPresenceExample {
    public static void main(String[] args) {
        final Optional<String> optional = getStringForEvenNumber(6);
        if (optional.isPresent()) {
            System.out.println("I am optional with a value, I am non empty box");
        } else if (optional.isEmpty()) {
            System.out.println("I am an empty optional");
        }

        optional.ifPresent(System.out::println); // writing the values to a box on the screen, only if available
    }

    private static Optional<String> getStringForEvenNumber(final int number) {
        if (number % 2 == 0) {
            return Optional.of("even");
        }
        return Optional.empty();
    }
}


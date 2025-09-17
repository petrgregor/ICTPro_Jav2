package cz.ictpro.functional_programming.lesson;

import java.util.Optional;

public class CreatingOptionals {
    public static void main(String[] args) {
        final Optional<String> stringOptional = Optional.of("This is SDA!"); // creating a box with an object of the String type

        Integer number = 1;
        String value = null;
        if (number % 2 == 0) {
            value = "I am even";
        }
        final Optional<String> optionalThatCanBeEmpty = Optional.ofNullable(value); // use ofNullable since value can be null. In this case, Optional will be an empty box
        System.out.println(value);
    }
}


package cz.ictpro.functional_programming.lesson;

import java.util.Optional;

public class OptionalOrElseExample {
    public static void main(String[] args) {
        String object = null;
        String name = Optional.ofNullable(object).orElse("john");
        System.out.println(name); // the value john will be printed on the screen
    }
}


package cz.ictpro.functional_programming.lesson;

import java.util.Optional;

public class OptionalOrElseGetExample {
    public static void main(String[] args) {
        String object = null;
        String name = Optional.ofNullable(object).orElseGet(() -> "john");
        System.out.println(name); // String john reappears on the screen
    }
}

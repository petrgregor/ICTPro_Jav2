package cz.ictpro.functional_programming.lesson;

import java.util.List;
import java.util.function.Consumer;

public class MethodReferences {
    public static void main(String[] args) {

        Consumer<String> consumerExample = someString -> System.out.println(someString); // use of lambda
        consumerExample.accept("Hello, World!");

        Consumer<String> consumerExampleReference = System.out::println; // identical notation as in the line above, use of references
        consumerExampleReference.accept("Great.");

        //List.of("someString").stream().map(str -> str.toUpperCase()); // using lambda in the map method

        //List.of("someString").stream().map(String::toUpperCase); // using a reference to a method, equivalent notation in the line of code above

    }
}

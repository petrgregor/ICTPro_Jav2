package cz.ictpro.inner_classes.lesson;

import java.util.List;

public class LocalClassExample {
    public static void main(String[] args) {
        final List<String> names = List.of("Kate", "Maggie", "Peggie");
        final List<String> surnames = List.of("Jones", "Smith", "Budden");
        final int someVariable = 3; // variable to represent the access of local class variables

        class Name { // creating a local class definition, without an access modifier
            private final String firstName;
            private final String lastName;

            public Name(final String firstName, final String lastName) {
                this.firstName = firstName;
                this.lastName = lastName;
            }

            public String getReadableName() {
                System.out.println("Hey I can use outer variable " + someVariable);
                return firstName + " " + lastName;
            }
        }

        for (int idx = 0; idx < names.size(); idx++) {
            final Name name = new Name(names.get(idx), surnames.get(idx)); // use of local class
            System.out.println(name.getReadableName());
        }

        // The example below shows the limits of local classes:
        class InnerClassExample {
            private static final String APP_NAME = "DummyApp"; // OK
            //private static String INCORRECT_FIELD = "IAmMissingFinal"; // Compilation error, no final modifier

            public void printAppName() {
                System.out.println(APP_NAME);
            }

            //public static void shouldNotBeDeclaredHere() {} // Compile error, static method in local class
        }

        final InnerClassExample innerClassExample = new InnerClassExample();
        innerClassExample.printAppName();
        //innerClassExample.shouldNotBeDeclaredHere();
    }
}

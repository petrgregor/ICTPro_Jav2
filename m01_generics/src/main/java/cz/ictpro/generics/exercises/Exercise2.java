package cz.ictpro.generics.exercises;

/*
Task 2
Design the countIf generic method which, based on an array of elements of any
type will count the number of elements meeting the condition using a
functional interface. Any interface implemented anonymously can be a function.
 */

public class Exercise2 {
    public static void main(String[] args) {
        Integer[] tab = {10, 21, 33, 40, 50, 60};
        int counter = Utils.countIf(tab, new Validator<Integer>()
        {
            @Override
            public boolean validate(Integer value) {
                return value % 3 == 0;
            }
        });
        System.out.println(counter);
    }
}

interface Validator<T> {
    boolean validate(T value);
}

class Utils {
    public static <T> int countIf(T[] tab, Validator<T> validator)
    {
        int counter = 0;
        for (T element : tab) {
            if (validator.validate(element)) {
                counter++;
            }
        }
        return counter;
    }
}

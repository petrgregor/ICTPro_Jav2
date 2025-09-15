package cz.ictpro.generics;

import java.util.List;

public class LowerBoundedWildcards {

    public static void addNumbers(List<? super Integer> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
    }
}


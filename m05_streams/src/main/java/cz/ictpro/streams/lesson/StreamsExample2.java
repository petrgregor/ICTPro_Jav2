package cz.ictpro.streams.lesson;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsExample2 {
    public static void main(String[] args) {
        // creating a stream and processing the input elements of the Integer type to a value three times greater of the Double type
        List.of(1, 2, 3).stream()
                .map(streamElem -> streamElem * 3.0);


        final Statistics statisticsA = new Statistics(2.0, List.of(1, 2, 3));
        final Statistics statisticsB = new Statistics(2.5, List.of(2, 3, 2, 3));
        Stream.of(statisticsA, statisticsB)
                .flatMap(statistics -> statistics.getValues().stream()); // 1, 2, 3, 2, 3, 2, 3


        final int[] idx = { 0 };
        Stream.generate(() -> idx[0]++)
                .limit(10)
                .filter(elem -> elem % 2 == 0); //the following values remain in the stream: 0, 2, 4, 6, 8


        Arrays.asList(6, 3, 6, 21, 20, 1).stream()
                .sorted(Comparator.reverseOrder()); // in the stream you will find: 21, 20, 6, 6, 3, 1 - in this order


        Arrays.asList(3, 6, 6, 20, 21, 21).stream()
                .distinct(); // there will be items in the stream: 3, 6, 20, 21


        List.of(1, 2, 3, 4, 5).stream()
                .forEach(System.out::println);


        final List<Integer> listCreatedFromCollectMethod = Stream.generate(() -> new Random().nextInt())
                .limit(10)
                .distinct()
                .filter(elem -> Math.abs(elem) < 1000)
                .collect(Collectors.toUnmodifiableList());

        final String sentence = Stream.of("This", "will", "be", "single", "sentence", "but", "without", "some", "words")
                .filter(word -> word.length() > 2)
                .collect(Collectors.joining(" "));
        System.out.println(sentence); // "This will single sentence but without some words"

        final Map<String, String> wordToUppercasedVersion = Stream.of("Hello", "from", "Stream", "api")
                .collect(Collectors.toMap(Function.identity(), String::toUpperCase));


        Stream.of("This", "is", "ICT", "the", "best", "academy", "in", "the", "universe")
                .collect(Collectors.groupingBy(String::length))
                .forEach((key, value) -> System.out.println(key + " " + value));
        /* the result is:
        2 [is, in]
        3 [ICT, the, the]
        4 [This, best]
        7 [academy]
        8 [universe]
        */


        List.of("who", "will", "be", "first").stream()
                .sorted()
                .findFirst() // zwraca Optional
                .ifPresent(System.out::println); // will display "be"


        List.of(7, 21, 13, 4, 8).stream()
                .filter(x -> x % 2 == 0)
                .findAny()
                .ifPresent(System.out::println);


        final Integer sum = List.of(2, 5, 9, 19, 14).stream()
                .reduce(0, (currentSum, streamElement) -> currentSum + streamElement); // or Integer::sum
        System.out.println(sum); // the result is a sum - 49


        final List<String> result = Arrays.asList("Alice has a cat named Catson".split(" ")).parallelStream()
                .sorted()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

    }
}

class Statistics {
    private double average;
    private List<Integer> values;

    public Statistics(final double average, final List<Integer> values) {
        this.average = average;
        this.values = values;
    }

    public double getAverage() {
        return average;
    }

    public List<Integer> getValues() {
        return values;
    }
}
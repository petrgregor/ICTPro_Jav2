package cz.ictpro.streams.lesson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsExample1 {
    public static void main(String[] args) {
        Stream<Integer> streamOfInts = Arrays.asList(1, 2, 3).stream();
        Stream<String> streamOfStrings = Set.of("one", "two", "three").stream();
        Stream<Map.Entry<String, Integer>> stream = Map.of("someKeyA", 1, "someKeyB", 2).entrySet().stream();
        IntStream arraysStream = Arrays.stream(new int[]{1, 2, 3});
        Stream<Double> ofStream = Stream.of(1.1, 2.2, 3.3);
        Stream<Integer> generateStream = Stream.generate(() -> new Random().nextInt());
        try {
            Stream<String> fileLinesStream = Files.lines(Path.of("/tmp/1.txt"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

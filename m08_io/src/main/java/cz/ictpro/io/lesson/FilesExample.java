package cz.ictpro.io.lesson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FilesExample {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("data.txt");
        Path pathToCopy = Paths.get("data_copy.txt");

        Files.delete(path);
        Files.createFile(path);

        Files.write(path, "test data".getBytes(), StandardOpenOption.WRITE);
        Files.write(path, "first line".getBytes(), StandardOpenOption.APPEND); // APPEND
        Files.write(path, "second line".getBytes(), StandardOpenOption.APPEND);

        for (String line : Files.readAllLines(path)) {
            System.out.println(line);
        }

        Files.copy(path, pathToCopy);
        Files.delete(pathToCopy);
    }
}

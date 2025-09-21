package cz.ictpro.io.exercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Exercise6 {
    public static void main(String[] args) throws IOException {
        MovieFileRepository movieFileRepository = new
                MovieFileRepository();
        movieFileRepository.add(new Movie("Star Wars Force Awaken", "Action", "J.J Ambrams", 2015));
                movieFileRepository.add(new Movie("Star Wars Last Jedi",
                        "Action", "J.J Ambrams", 2017));
        System.out.println("Results :" +
                movieFileRepository.getAll());
    }
}
class MovieFileRepository {
    private final MovieParser movieParser = new MovieParser();
    private final static Path PATH =
            Paths.get("movie.txt");
    public void add(Movie movie) throws IOException {
        Files.writeString(PATH, movieParser.toCSV(movie),
                StandardOpenOption.APPEND);
    }
    public List<Movie> getAll() throws IOException {
        List<String> movieLines = Files.readAllLines(PATH);
        List<Movie> movies = new ArrayList<>();
        for (String line : movieLines) {
            Movie movie = movieParser.fromCSV(line);
            movies.add(movie);
        }
        return movies;
    }
}
class MovieParser {
    private static final String SEPARATOR = ",";
    public Movie fromCSV(String line) {
        String[] data = line.split(SEPARATOR);
        return new Movie(data[0], data[1], data[2],
                Integer.parseInt(data[3]));
    }
    public String toCSV(Movie movie) {
        return new StringBuilder().append(movie.getTitle())
                .append(SEPARATOR)
                .append(movie.getGenre())
                .append(SEPARATOR)
                .append(movie.getDirector())
                .append(SEPARATOR)
                .append(movie.getYearOfRelease())
                .append("\n")
                .toString();
    }
}



package cz.ictpro.io.lesson;

import java.io.*;

public class Movie implements Serializable {
    private int id;
    private String title;
    private String type;

    public Movie(int id, String title, String type) {
        this.id = id;
        this.title = title;
        this.type = type;
    }

    //getters and setters

    public final void writeObject(/*Object x*/) throws IOException {
        try {
            //Movie movieToSerialize = new Movie(1123, "Star Wars", "Start Wars IX");
            FileOutputStream fileOutputStream = new FileOutputStream("movies.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
            out.writeObject(this);
            out.flush();
            out.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static final Object readObject() throws IOException, ClassNotFoundException {
        try {
            FileInputStream fileIn = new FileInputStream("movies.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Movie movieToDeserialize = (Movie) in.readObject();
            in.close();
            fileIn.close();
            System.out.println(movieToDeserialize);
            return movieToDeserialize;
        } catch (Exception e) {
            System.err.println(e);
        }

        return null;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Movie movie = new Movie(1, "Star Wars", "Start Wars IX");
        movie.writeObject();
        //Movie movie1 = new Movie(1, "Star Wars", "Start Wars IX");
        Movie movie1 = (Movie) Movie.readObject();
        System.out.println(movie1);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}


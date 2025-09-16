package cz.ictpro.generics.exercises;

/*
Task 4
Create a class that will behave like a library for the following types of media:
- books
- newspapers
- movies
Please provide a solution for generic types. For data collection, use any array or
Collection API class.
 */

import java.util.Arrays;

public class Exercise4 {
    public static void main(String[] args) {
        Library<Book> bookLibrary = new Library<>(new Book[]{new
                Book("Harry Potter", "Fantasy")});
        System.out.println(Arrays.toString(bookLibrary.getElements()));
        Library<Movie> movieLibrary = new Library<>(new Movie[]
                {new Movie("Star Wars", "J.J Ambrams")});
        System.out.println(Arrays.toString(movieLibrary.getElements()));
        Library<Newspaper> newspaperLibrary = new Library<>(new
                Newspaper[]{new Newspaper("NYC", "US")});
        System.out.println(Arrays.toString(newspaperLibrary.getElements()));
    }
}

abstract class MediaContent {
    protected String title;

    public MediaContent(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

class Book extends MediaContent {
    private String author;

    public Book(String title, String author) {
        super(title);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

class Newspaper extends MediaContent {
    private String editor;

    public Newspaper(String title, String editor) {
        super(title);
        this.editor = editor;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    @Override
    public String toString() {
        return "Newspaper{" +
                "title='" + title + '\'' +
                ", editor='" + editor + '\'' +
                '}';
    }
}

class Movie extends MediaContent {
    private String director;

    public Movie(String director, String title) {
        super(title);
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", director='" + director + '\'' +
                '}';
    }
}

class Library<T extends MediaContent> {
    private T[] elements;

    public Library(T[] elements) {
        this.elements = elements;
    }

    public T[] getElements() {
        return elements;
    }

    public void setElements(T[] elements) {
        this.elements = elements;
    }
}

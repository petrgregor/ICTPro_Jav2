package cz.ictpro.collections.exercises;

import java.util.*;

public class Exercise2 {
    public static void main(String[] args) {
        Author author1 = new Author("John", "Smith", 'M');
        Author author2 = new Author("Jessica", "Albana", 'F');
        Author author3 = new Author("Roger", "Moore", 'M');
        Author author4 = new Author("Catherin", "Nadie", 'F');
        Book book1 = new Book("Book 1", 34, 2000,
                Arrays.asList(author1), Genre.FANTASY);
        Book book2 = new Book("Book 1", 56, 1999,
                Arrays.asList(author2, author3, author4), Genre.ACTION);
        BookService bookService = new BookService();
        bookService.add(book1);
        bookService.add(book2);
        System.out.println(bookService.findByAuthor(author2));
        System.out.println(bookService.getAll());
        System.out.println(bookService.findMostExpensiveBook());
        System.out.println(bookService.sortByTitleAsc());
        System.out.println(bookService.sortByTitleDsc());
    }
}
class Author {
    private String name;
    private String lastName;
    private char gender;
    public Author(String name, String lastName, char gender) {
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return gender == author.gender &&
                Objects.equals(name, author.name) &&
                Objects.equals(lastName, author.lastName);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, gender);
    }
    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                '}';
    }
}
enum Genre {
    ACTION, FANTASY, CRIME
}
class Book implements Comparable<Book> {
    private String title;
    private float price;
    private int yearOfRelease;
    private List<Author> authors;
    private Genre genre;
    public Book(String title, float price, int yearOfRelease,
                List<Author> authors, Genre genre) {
        this.title = title;
        this.price = price;
        this.yearOfRelease = yearOfRelease;
        this.authors = authors;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public int getYearOfRelease() {
        return yearOfRelease;
    }
    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }
    public List<Author> getAuthors() {
        return authors;
    }
    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
    public Genre getGenre() {
        return genre;
    }
    public void setGenre(Genre genre) {
        this.genre = genre;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Float.compare(book.price, price) == 0 &&
                yearOfRelease == book.yearOfRelease &&
                Objects.equals(title, book.title) &&
                Objects.equals(authors, book.authors) &&
                genre == book.genre;
    }
    @Override
    public int hashCode() {
        return Objects.hash(title, price, yearOfRelease, authors,
                genre);
    }
    @Override
    public int compareTo(Book o) {
        return o.getTitle().compareTo(title);
    }
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", yearOfRelease=" + yearOfRelease +
                ", authors=" + authors +
                ", genre=" + genre +
                '}';
    }
}
class BookService {
    private List<Book> books = new ArrayList<>();
    public void add(Book book) {
        books.add(book);
    }
    public void remove(Book book) {
        books.remove(book);
    }
    public List<Book> getAll() {
        return books;
    }
    public List<Book> findByGenre(Genre genre) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getGenre() == genre) {
                results.add(book);
            }
        }
        return results;
    }
    public List<Book> findByYear(int yearOfRelease) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getYearOfRelease() < yearOfRelease) {
                results.add(book);
            }
        }
        return results;
    }
    public Book findMostExpensiveBook() {
        Book result = null;
        for (Book book : books) {
            if (result == null || result.getPrice() <
                    book.getPrice()) {
                result = book;
            }
        }
        return result;
    }
    public Book findCheapestBook() {
        Book result = null;
        for (Book book : books) {
            if (result == null || result.getPrice() >
                    book.getPrice()) {
                result = book;
            }
        }
        return result;
    }
    public List<Book> findByNumberOfAuthors(int numberOfAuthors) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthors().size() == numberOfAuthors) {
                results.add(book);
            }
        }
        return results;
    }
    public List<Book> sortByTitleAsc() {
        Collections.sort(books);
        return books;
    }

    public List<Book> sortByTitleDsc() {
        Collections.reverse(books);
        return books;
    }
    public boolean isBookInRepo(Book book) {
        return books.contains(book);
    }
    public List<Book> findByAuthor(Author author) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthors().contains(author)) {
                results.add(book);
            }
        }
        return results;
    }
}

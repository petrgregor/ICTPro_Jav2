package cz.ictpro.io.exercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Exercise5 {
    public static void main(String[] args) throws IOException {
        UserParser userParser = new UserParser();
        Path path =
                Paths.get("users.csv");
        List<User> users = new ArrayList<>();
        List<String> lines = Files.readAllLines(path);
        for (String line : lines) {
            User user = userParser.fromCSV(line);
            users.add(user);
        }
        System.out.println("Results " + users);
    }
}
class UserParser {
    public User fromCSV(String csvLine) {
        String[] data = csvLine.split(",");
        return new User(data[0], data[1],
                Integer.parseInt(data[2]));
    }
}
class User {
    private String name;
    private String lastName;
    private int age;
    public User(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
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
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}

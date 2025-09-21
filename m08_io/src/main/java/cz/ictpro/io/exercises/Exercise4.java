package cz.ictpro.io.exercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) throws
            FileNotFoundException {
        String longestWord = new Exercise4().findLongestWords();
        System.out.println(longestWord);
    }
    public String findLongestWords() throws FileNotFoundException
    {
        String longestWord = "";
        String current;
        Scanner scanner = new Scanner(new File("user.txt"));
        while (scanner.hasNext()) {
            current = scanner.next();
            if (current.length() > longestWord.length()) {
                longestWord = current;
            }
        }
        return longestWord;
    }
}

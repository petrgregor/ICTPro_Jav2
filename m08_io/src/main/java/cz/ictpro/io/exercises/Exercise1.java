package cz.ictpro.io.exercises;

import java.io.File;

public class Exercise1 {
    public static void main(String[] args) {
//replace with sample directory path on Your OS
        File file = new File(".");
        String[] fileList = file.list();
        for (String name : fileList) {
            System.out.println(name);
        }
    }
}

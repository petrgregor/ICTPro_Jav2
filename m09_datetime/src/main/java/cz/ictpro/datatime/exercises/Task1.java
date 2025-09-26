package cz.ictpro.datatime.exercises;

import java.time.LocalDate;

public class Task1 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2025, 10, 26);
        System.out.println("Date " + date + " is earlier than now: " +
                isEarlierThanNow(date));
    }
    public static boolean isEarlierThanNow(LocalDate date) {
        LocalDate now = LocalDate.now();
        System.out.println("Now is: " + now);
        return date.isBefore(now);
    }
}
package cz.ictpro.datatime.lesson;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Example01 {
    public static void main(String[] args) {
        String str_separator = "=".repeat(30);


        System.out.println(str_separator + " LocalTime - now " + str_separator);
        LocalTime localTime = LocalTime.now();
        System.out.println("Current time: " + localTime); // Current time: 22:34:27.106


        System.out.println("\n" + str_separator + " LocalTime - with* " + str_separator);
        LocalTime localTime1 = LocalTime.now()
                .withSecond(0) // set the seconds to 0
                .withNano(0); // set nanoseconds to 0
        System.out.println("Current time: " + localTime1); // Current time: 22:41


        System.out.println("\n" + str_separator + " LocalTime - plus* / minus* " + str_separator);
        LocalTime now = LocalTime.now();
        System.out.println("Current time: " + now); // Current time: 22:49:01.241
        now = now.plusMinutes(10).plusHours(1);
        System.out.println("Current time after addition: " + now); // Current time after addition: 23:59:01.241


        System.out.println("\n" + str_separator + " LocalTime - get* " + str_separator);
        LocalTime now1 = LocalTime.now();
        String formattedTime = now1.getHour() + ":" + now1.getMinute() + ":" + now1.getSecond();
        System.out.println(formattedTime); // 22:55:26


        System.out.println("\n" + str_separator + " LocalDate - mow " + str_separator);
        LocalDate now2 = LocalDate.now();
        System.out.println(now2); // 2025-10-10


        System.out.println("\n" + str_separator + " LocalDate - of " + str_separator);
        LocalDate localDate = LocalDate.of(2025, Month.MARCH, 28);
        System.out.println(localDate); // 2025-03-28

        //LocalDate localDate1 = LocalDate.of(2025, Month.FEBRUARY, 29);
        //System.out.println(localDate1); // 2025-03-28


        System.out.println("\n" + str_separator + " LocalDateTime - mow " + str_separator);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime); // 2025-10-10T20:25:16.124


        System.out.println("\n" + str_separator + " LocalDateTime - of " + str_separator);
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, Month.MARCH, 28, 20, 0, 10, 0);
        System.out.println(localDateTime1); // 2020-03-28T20:00:10


        System.out.println("\n" + str_separator + " Instant - mow " + str_separator);
        Instant instant = Instant.now();
        LocalDateTime localDateTime2 = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        System.out.println(localDateTime2); // 2025-10-10T18:33:29.116691800

        LocalTime localTime2 = LocalTime.ofInstant(instant, ZoneId.of("CET"));
        System.out.println(localTime2); // 18:33:29.116691800

        LocalDate localDate2 = LocalDate.ofInstant(instant, ZoneId.ofOffset("UTC", ZoneOffset.ofHours(2)));
        System.out.println(localDate2); // 2025-10-10



        System.out.println("\n" + str_separator + " Duration " + str_separator);
        System.out.println(Duration.ofHours(10).toMinutes()); // 10 hours expressed in minutes: 600

        // In the example below, the time difference in minutes between the current time and the time 2 days later was calculated
        System.out.println(Duration.between(LocalDateTime.now(), LocalDateTime.now().plusDays(2)).toMinutes()); // 2880

        // The number of months between the two dates is calculated below.
        System.out.println(Period.between(LocalDate.now(), LocalDate.now().plusDays(100)).getMonths()); // 3


        System.out.println("\n" + str_separator + " Date display format " + str_separator);
        LocalTime localTime3 = LocalTime.now();
        String formattedLocalTime = localTime3.format(DateTimeFormatter.ISO_LOCAL_TIME);
        System.out.println(formattedLocalTime); // 21:11:00.024


        System.out.println("\n" + str_separator + " Date display format - own implementations " + str_separator);
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("MM:yyyy:dd"));
        System.out.println(date); // 04:2020:19

        System.out.println("\n" + str_separator + str_separator + str_separator);
    }
}

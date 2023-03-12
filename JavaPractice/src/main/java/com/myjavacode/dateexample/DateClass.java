package com.myjavacode.dateexample;


import org.threeten.bp.temporal.ChronoUnit;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateClass {
    public static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
    public static final String IST_ZONE_ID = "Asia/Kolkata";
    public static void main(String[] args) {
//        localTimeExample();
//        String isoDate = isoFormat();
//        System.out.println(isoDate);

//        LocalTime localTime = LocalTime.parse(isoDate, dateFormat);
//        LocalDate localDate = LocalDate.parse(isoDate, dateFormat);
//        System.out.println(localDate + " : " + localTime);
//
//        LocalTime newLocalTime = localTime.plusNanos(1000000);
//        System.out.println("new time: " + newLocalTime);

        String dateTimeInIso = getDateInIsoFormat();
        System.out.println("current date time: " + dateTimeInIso);
        LocalDateTime localDateTime = LocalDateTime.parse(dateTimeInIso, dateFormat);

//        System.out.println(localDateTime);
//        System.out.println(localDateTime.plusNanos(1000000));

        LocalDateTime yeterDay = LocalDateTime.of(LocalDate.now(ZoneId.of(IST_ZONE_ID)).minusDays(1), LocalTime.MAX);

        System.out.println(yeterDay.plusNanos(1));

    }

    public static void localTimeExample() {
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        LocalTime newLocalTime = localTime.plusHours(1);
        System.out.println(newLocalTime);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
    }

    public static String getDateInIsoFormat() {
        return ZonedDateTime.of(LocalDateTime.of(LocalDate.now(ZoneId.of(IST_ZONE_ID)).minusDays(1), LocalTime.MAX), ZoneId.of(IST_ZONE_ID))
                .format(dateFormat);
//        return LocalDateTime.of(LocalDate.now(ZoneId.of(IST_ZONE_ID)).minusDays(1), LocalTime.MAX)
//                .format(dateFormat);
//        return ZonedDateTime.of(
//                LocalDate.now().minusDays(1),
//                LocalTime.MAX,
//                ZoneId.of("Asia/Kolkata")
//        ).format(dateFormat);

    }
}

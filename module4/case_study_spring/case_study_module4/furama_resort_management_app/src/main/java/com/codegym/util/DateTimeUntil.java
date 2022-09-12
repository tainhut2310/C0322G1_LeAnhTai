package com.codegym.util;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DateTimeUntil {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static boolean formatterAge(String age) {
        LocalDate localDate = LocalDate.parse(age, formatter);
        return Period.between(localDate, LocalDate.now()).getYears() < 18;
    }

    public static boolean formatterDate(String startDate, String endDate) {
        LocalDate localStartDate = LocalDate.parse(startDate, formatter);
        LocalDate localEndDate = LocalDate.parse(endDate, formatter);
        return Period.between(localStartDate,localEndDate).getDays() < 0;
    }
}

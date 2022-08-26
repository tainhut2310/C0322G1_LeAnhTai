package com.codegym.until;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DateTimeUntil {
    public static boolean formatterAge(String age, DateTimeFormatter formatter) {
        LocalDate localDate = LocalDate.parse(age, formatter);
        int current = Period.between(localDate, LocalDate.now()).getYears();
        return current < 18;
    }
}

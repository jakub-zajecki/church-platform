package com.churcher.churchplatform.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Test {

    private static final List<LocalDate> calendar = new ArrayList<>();

    public static void main(String[] args) {
        fill();
        System.out.println(calendar);
    }

    private static void fill(){
        LocalDate yearBefore = LocalDate.ofYearDay(LocalDate.now().getYear(), 1);
        LocalDate limitDay = LocalDate.of(LocalDate.now().getYear() + 2, 1,1);
        LocalDate dayToAdd = yearBefore;
        while(dayToAdd.isBefore(limitDay)){
            calendar.add(dayToAdd);
            dayToAdd = dayToAdd.plusDays(1);
        }
    }

}

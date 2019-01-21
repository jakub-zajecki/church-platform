package com.churcher.churchplatform.model;

import com.churcher.churchplatform.enums.Holidays;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CalendarBase {

    private static final List<LocalDate> calendar = fillCalendar();

//    public static void main(String[] args) {
//        checkForHolidays(4,2025);
//    }

    private static List<LocalDate> fillCalendar(){
        LocalDate yearBefore = LocalDate.ofYearDay(LocalDate.now().getYear() - 1, 1);
        LocalDate limitDay = LocalDate.of(LocalDate.now().getYear() + 2, 1,1);
        LocalDate dayToAdd = yearBefore;
        ArrayList<LocalDate> calendar = new ArrayList<>();
        while(dayToAdd.isBefore(limitDay)){
            calendar.add(dayToAdd);
            dayToAdd = dayToAdd.plusDays(1);
        }
        return calendar;
    }

    private static LocalDate calculateEaster(int year){
        int firstFactor = year % 19;
        int secondFactor = year % 4;
        int thirdFactor = year % 7;
        int fourthFactor = (firstFactor * 19 + 24) % 30;
        int fifthFactor = (2 * secondFactor + 4 * thirdFactor + 6 * fourthFactor + 5) % 7;
        LocalDate easterDay = LocalDate.of(year, 3,22).plusDays(fourthFactor).plusDays(fifthFactor);
        return easterDay;
    }

    private static Map<LocalDate, Holidays> createHolidays(int year){
        Map<LocalDate, Holidays> holidays = new HashMap<>();
        holidays.put(calculateEaster(year), Holidays.EASTER_FIRST);
        holidays.put(LocalDate.of(year, 12, 25), Holidays.CHRISTMAS_FIRST);
        return holidays;
    }

//    private static void checkForHolidays(int month, int year){
//        List<LocalDate> monthList = getMonth(month, year);
//        Map<LocalDate, Holidays> holidays = createHolidays(year);
//        for(LocalDate key : holidays.keySet()){
//            if(monthList.contains(key)){
//                System.out.println("Jest święto " + holidays.get(key) + " " + key);
//            }
//        }
//    }

}
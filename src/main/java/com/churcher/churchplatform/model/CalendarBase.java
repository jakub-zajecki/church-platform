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
package com.churcher.churchplatform.service.impl;

import com.churcher.churchplatform.enums.Holidays;
import com.churcher.churchplatform.service.CalendarService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CalendarServiceImpl implements CalendarService {

    @Override
    public List<LocalDate> getMonth(int month, int year) {
        List<LocalDate> monthList = new ArrayList<>();
        if(month < 1 || month > 13){
            return getMonth(LocalDate.now().getMonthValue(), LocalDate.now().getYear());
        }
        if(year < 1000 || year > 3000) {
            return getMonth(LocalDate.now().getMonthValue(), LocalDate.now().getYear());
        }
        LocalDate dayToAdd = LocalDate.of(year, month, 1);
        LocalDate nextMonthFirstDay = dayToAdd.plusMonths(1);
        while(dayToAdd.isBefore(nextMonthFirstDay)){
            monthList.add(dayToAdd);
            dayToAdd = dayToAdd.plusDays(1);
        }
        return monthList;
    }

    private LocalDate calculateEaster(int year){
        int firstFactor = year % 19;
        int secondFactor = year % 4;
        int thirdFactor = year % 7;
        int fourthFactor = (firstFactor * 19 + 24) % 30;
        int fifthFactor = (2 * secondFactor + 4 * thirdFactor + 6 * fourthFactor + 5) % 7;
        LocalDate easterDay = LocalDate.of(year, 3,22).plusDays(fourthFactor).plusDays(fifthFactor);
        return easterDay;
    }

    @Override
    public Map<LocalDate, Holidays> createHolidays(int year){
        Map<LocalDate, Holidays> holidays = new HashMap<>();
        holidays.put(calculateEaster(year), Holidays.EASTER_FIRST);
        holidays.put(LocalDate.of(year, 12, 25), Holidays.CHRISTMAS_FIRST);

        LocalDate date = getFirstSunday(year);
        while(date.getYear() == year){
            holidays.put(date, Holidays.SUNDAY);
            date = date.plusDays(7);
        }
        return holidays;
    }

    private LocalDate getFirstSunday(int year){
        LocalDate date = LocalDate.of(year,1, 1);
        while(date.getDayOfWeek().getValue() != 7){
            date = date.plusDays(1);
        }
        return date;
    }



}

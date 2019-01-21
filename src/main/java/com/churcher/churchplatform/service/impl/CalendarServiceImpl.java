package com.churcher.churchplatform.service.impl;

import com.churcher.churchplatform.service.CalendarService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
}

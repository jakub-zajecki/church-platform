package com.churcher.churchplatform.service;

import com.churcher.churchplatform.enums.Holidays;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface CalendarService {

    List<LocalDate> getMonth(int month, int year);
    Map<LocalDate, Holidays> createHolidays(int year);

}

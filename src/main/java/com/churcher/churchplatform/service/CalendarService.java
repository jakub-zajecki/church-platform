package com.churcher.churchplatform.service;

import java.time.LocalDate;
import java.util.List;

public interface CalendarService {

    List<LocalDate> getMonth(int month, int year);

}

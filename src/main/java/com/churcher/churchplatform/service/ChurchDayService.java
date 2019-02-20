package com.churcher.churchplatform.service;

import com.churcher.churchplatform.enums.DayType;
import com.churcher.churchplatform.model.ChurchDay;

import java.time.LocalDate;

public interface ChurchDayService {

    public ChurchDay churchDayBuilder(LocalDate localDate, Long churchId, DayType dayType);

    public ChurchDay setNormalChurchDay(LocalDate localDate, Long churchId);
    public ChurchDay setHolidayChurchDay(LocalDate localDate, Long churchId);

    void save(ChurchDay churchDay);

}

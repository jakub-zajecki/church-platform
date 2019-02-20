package com.churcher.churchplatform.service;

import com.churcher.churchplatform.model.Church;
import com.churcher.churchplatform.model.HolidayMassTime;

import java.time.LocalTime;
import java.util.List;

public interface HolidayMassTimeService {

    public void delateHolidayMassTime(Long id);

    public void saveHolidayTimeMass(HolidayMassTime holidayMassTime);

    public HolidayMassTime createHolidayMassTime(LocalTime localTime, Church church);

    List<HolidayMassTime> getAllByChurchId(Long id);
}

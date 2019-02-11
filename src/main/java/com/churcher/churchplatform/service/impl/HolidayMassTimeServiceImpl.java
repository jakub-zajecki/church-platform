package com.churcher.churchplatform.service.impl;

import com.churcher.churchplatform.dao.HolidayMassTimeRepository;
import com.churcher.churchplatform.model.Church;
import com.churcher.churchplatform.model.HolidayMassTime;
import com.churcher.churchplatform.service.HolidayMassTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class HolidayMassTimeServiceImpl implements HolidayMassTimeService {

    private HolidayMassTimeRepository holidayMassTimeRepository;


    @Autowired
    public HolidayMassTimeServiceImpl(HolidayMassTimeRepository holidayMassTimeRepository) {
        this.holidayMassTimeRepository = holidayMassTimeRepository;
    }

    @Override
    public void delateHolidayMassTime(Long id) {
        holidayMassTimeRepository.deleteById(id);
    }

    @Override
    public void saveHolidayTimeMass(HolidayMassTime holidayMassTime) {
        holidayMassTimeRepository.save(holidayMassTime);
    }

    @Override
    public HolidayMassTime createHolidayMassTime(LocalTime localTime, Church church) {

        HolidayMassTime holidayMassTime = new HolidayMassTime();
        holidayMassTime.setMassTime(localTime);
        holidayMassTime.setChurch(church);

        return holidayMassTime;
    }
}

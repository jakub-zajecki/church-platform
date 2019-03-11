package com.churcher.churchplatform.service.impl;

import com.churcher.churchplatform.dao.ChurchDayRepository;
import com.churcher.churchplatform.dao.ChurchRepository;
import com.churcher.churchplatform.enums.DayType;
import com.churcher.churchplatform.model.ChurchDay;
import com.churcher.churchplatform.model.HolidayMassTime;
import com.churcher.churchplatform.model.Mass;
import com.churcher.churchplatform.model.NormalDayMassTime;
import com.churcher.churchplatform.service.ChurchDayService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChurchDayServiceImpl implements ChurchDayService {

    private ChurchDayRepository churchDayRepository;
    private ChurchRepository churchRepository;

    public ChurchDayServiceImpl(ChurchDayRepository churchDayRepository,ChurchRepository churchRepository) {
        this.churchDayRepository = churchDayRepository;
        this.churchRepository = churchRepository;
        
    }

    @Override
    public ChurchDay churchDayBuilder(LocalDate localDate, Long churchId, DayType dayType) {
        if(churchDayRepository.findByLocalDateAndChurchId(localDate,churchId)== null){
            if(dayType == DayType.NORMAL){
                return setNormalChurchDay(localDate,churchId);
            } else return setHolidayChurchDay(localDate,churchId);

        }   return churchDayRepository.findByLocalDateAndChurchId(localDate,churchId);

    }

    @Override
    public ChurchDay findByLocalDateAndChurchId(LocalDate localDate, Long churchId) {
        return churchDayRepository.findByLocalDateAndChurchId(localDate,churchId);
    }

    @Override
    public ChurchDay setNormalChurchDay(LocalDate localDate, Long churchId) {
        ChurchDay normalChurchDay = new ChurchDay();
        List<Mass> normalChurchDayMassList = new ArrayList<>();
        List<NormalDayMassTime> normalChurchDayMassTimeList = churchRepository.findChurchById(churchId).getNormalChurchDayList();
       for (NormalDayMassTime masstime : normalChurchDayMassTimeList){
           Mass normalDayMass = new Mass();
           normalDayMass.setMassTime(masstime.getMassTime());
           normalChurchDayMassList.add(normalDayMass);
       }
        normalChurchDay.setLocalDate(localDate);
        normalChurchDay.setDayType(DayType.NORMAL);
        normalChurchDay.setChurch(churchRepository.findChurchById(churchId));
        normalChurchDay.setMassList(normalChurchDayMassList);

        return normalChurchDay;
    }

    @Override
    public ChurchDay setHolidayChurchDay(LocalDate localDate, Long churchId) {
        ChurchDay holidayChurchDay = new ChurchDay();
        List<Mass> holidayChurchDayMassList = new ArrayList<>();
        List<HolidayMassTime> holidayChurchDayMassTimeList = churchRepository.findChurchById(churchId).getHolidayChurchDayList();
        for (HolidayMassTime masstime : holidayChurchDayMassTimeList){
            Mass holidayDayMass = new Mass();
            holidayDayMass.setMassTime(masstime.getMassTime());
            holidayChurchDayMassList.add(holidayDayMass);
        }
        holidayChurchDay.setLocalDate(localDate);
        holidayChurchDay.setDayType(DayType.HOLIDAY);
        holidayChurchDay.setChurch(churchRepository.findChurchById(churchId));
        holidayChurchDay.setMassList(holidayChurchDayMassList);


        return holidayChurchDay;
    }

    @Override
    public void save(ChurchDay churchDay) {
        churchDayRepository.save(churchDay);
    }
}

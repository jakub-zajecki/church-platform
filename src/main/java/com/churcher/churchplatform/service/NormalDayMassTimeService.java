package com.churcher.churchplatform.service;

import com.churcher.churchplatform.model.Church;
import com.churcher.churchplatform.model.NormalDayMassTime;

import java.time.LocalTime;

public interface NormalDayMassTimeService {

    public void delateNormalDayMassTime(Long id);

    public void saveNormalDayMassTime(NormalDayMassTime normalDayMassTime);

    public NormalDayMassTime createNormalDayMassTime(LocalTime localTime, Church church);

}

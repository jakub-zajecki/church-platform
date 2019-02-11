package com.churcher.churchplatform.service.impl;

import com.churcher.churchplatform.dao.NormalDayMassTimeRepository;
import com.churcher.churchplatform.model.Church;
import com.churcher.churchplatform.model.NormalDayMassTime;
import com.churcher.churchplatform.service.NormalDayMassTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class NormalDayMassTimeServiceImpl implements NormalDayMassTimeService {

    private NormalDayMassTimeRepository normalDayMassTimeRepository;


    @Autowired
    public NormalDayMassTimeServiceImpl(NormalDayMassTimeRepository normalDayMassTimeRepository) {
        this.normalDayMassTimeRepository = normalDayMassTimeRepository;
    }

    @Override
    public void delateNormalDayMassTime(Long id) {
        normalDayMassTimeRepository.deleteById(id);
    }

    @Override
    public void saveNormalDayMassTime(NormalDayMassTime normalDayMassTime) {
        normalDayMassTimeRepository.save(normalDayMassTime);
    }

    @Override
    public NormalDayMassTime createNormalDayMassTime(LocalTime localTime, Church church) {

        NormalDayMassTime normalDayMassTime = new NormalDayMassTime();
        normalDayMassTime.setMassTime(localTime);
        normalDayMassTime.setChurch(church);

        return normalDayMassTime;
    }
}

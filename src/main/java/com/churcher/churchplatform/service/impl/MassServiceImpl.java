package com.churcher.churchplatform.service.impl;

import com.churcher.churchplatform.dao.ChurchDayRepository;
import com.churcher.churchplatform.dao.MassRepository;
import com.churcher.churchplatform.model.Mass;
import com.churcher.churchplatform.service.MassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class MassServiceImpl implements MassService {

    private MassRepository massRepository;
    private ChurchDayRepository churchDayRepository;

    @Autowired
    public MassServiceImpl(MassRepository massRepository, ChurchDayRepository churchDayRepository) {
        this.massRepository = massRepository;
        this.churchDayRepository = churchDayRepository;
    }

    @Override
    public void save(Mass mass) {
        massRepository.save(mass);
    }

    public Mass createMass(LocalTime massTime, Long churchDayId){
        Mass mass;
        if(massRepository.findByMassTimeAndChurchDayId(massTime, churchDayId) == null){
            mass = new Mass();
            mass.setChurchDay(churchDayRepository.findById(churchDayId).get());
            mass.setMassTime(massTime);
        } else {
            mass = massRepository.findByMassTimeAndChurchDayId(massTime, churchDayId);
        }
        return mass;
    }

    @Override
    public Mass findByMassTimeAndChurchDayId(LocalTime massTime, Long churchDayId) {
        return massRepository.findByMassTimeAndChurchDayId(massTime, churchDayId);
    }
}

package com.churcher.churchplatform.service;

import com.churcher.churchplatform.model.Mass;

import java.time.LocalTime;

public interface MassService {

    void save(Mass mass);
    Mass createMass(LocalTime massTime, Long churchDayId);
    Mass findByMassTimeAndChurchDayId(LocalTime massTime, Long churchDayId);

}

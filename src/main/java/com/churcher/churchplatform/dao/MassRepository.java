package com.churcher.churchplatform.dao;

import com.churcher.churchplatform.model.Mass;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalTime;

public interface MassRepository extends CrudRepository<Mass, Long> {

    Mass findByMassTimeAndChurchDayId(LocalTime massTime, Long churchDayId);

}

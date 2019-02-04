package com.churcher.churchplatform.dao;

import com.churcher.churchplatform.model.ChurchDay;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

public interface ChurchDayRepository extends CrudRepository<ChurchDay,Long> {

    public ChurchDay findByLocalDateAndChurchId(LocalDate localDate,Long churchId);

}

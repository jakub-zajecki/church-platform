package com.churcher.churchplatform.dao;


import com.churcher.churchplatform.model.HolidayMassTime;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HolidayMassTimeRepository extends CrudRepository<HolidayMassTime,Long> {

    public HolidayMassTime findHolidayMassTimeById(Long id);
    List<HolidayMassTime> findAllByChurchId(Long id);
}

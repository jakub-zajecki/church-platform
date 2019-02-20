package com.churcher.churchplatform.dao;

import com.churcher.churchplatform.model.Church;
import com.churcher.churchplatform.model.NormalDayMassTime;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NormalDayMassTimeRepository extends CrudRepository<NormalDayMassTime,Long> {

    public NormalDayMassTime findNormalDayMassTimeById(Long id);
    List<NormalDayMassTime> findAllByChurchId(Long id);
}

package com.churcher.churchplatform.dao;

import com.churcher.churchplatform.model.Church;
import com.churcher.churchplatform.model.NormalDayMassTime;
import org.springframework.data.repository.CrudRepository;

public interface NormalDayMassTimeRepository extends CrudRepository<NormalDayMassTime,Long> {

    public NormalDayMassTime findNormalDayMassTimeById(Long id);
}

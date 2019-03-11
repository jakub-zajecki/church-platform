package com.churcher.churchplatform.dao;

import com.churcher.churchplatform.model.PastoralVisit;
import org.springframework.data.repository.CrudRepository;

public interface PastoralVisitRepository extends CrudRepository<PastoralVisit, Long> {

    PastoralVisit findByChurchId(Long churchId);

}

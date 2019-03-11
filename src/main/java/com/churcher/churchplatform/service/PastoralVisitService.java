package com.churcher.churchplatform.service;

import com.churcher.churchplatform.model.PastoralVisit;

import java.time.LocalDate;
import java.util.List;

public interface PastoralVisitService {

    PastoralVisit findByChurchId(Long churchId);
    List<LocalDate> fillDaysBetween(LocalDate from, LocalDate to);
    void save(PastoralVisit pastoralVisit);
    void delete(PastoralVisit pastoralVisit);

}

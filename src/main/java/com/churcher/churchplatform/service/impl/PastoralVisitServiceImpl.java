package com.churcher.churchplatform.service.impl;

import com.churcher.churchplatform.dao.PastoralVisitRepository;
import com.churcher.churchplatform.model.PastoralVisit;
import com.churcher.churchplatform.service.PastoralVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PastoralVisitServiceImpl implements PastoralVisitService {

    private PastoralVisitRepository pastoralVisitRepository;

    @Autowired
    public PastoralVisitServiceImpl(PastoralVisitRepository pastoralVisitRepository) {
        this.pastoralVisitRepository = pastoralVisitRepository;
    }

    @Override
    public void save(PastoralVisit pastoralVisit){
        pastoralVisitRepository.save(pastoralVisit);
    }

    @Override
    public void delete(PastoralVisit pastoralVisit){
        pastoralVisitRepository.delete(pastoralVisit);
    }

    @Override
    public PastoralVisit findByChurchId(Long churchId) {
        return pastoralVisitRepository.findByChurchId(churchId);
    }

    @Override
    public List<LocalDate> fillDaysBetween(LocalDate from, LocalDate to){
        List<LocalDate> list = new ArrayList<>();
        while(!from.equals(to)){
            list.add(from);
            from = from.plusDays(1);
        }
        list.add(to);
        return list;
    }

}

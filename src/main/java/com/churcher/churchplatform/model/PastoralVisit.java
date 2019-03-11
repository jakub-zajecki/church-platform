package com.churcher.churchplatform.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@Entity
public class PastoralVisit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Church church;
    private HashMap<LocalDate, List<String>> datesAndStreets;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Church getChurch() {
        return church;
    }

    public void setChurch(Church church) {
        this.church = church;
    }

    public HashMap<LocalDate, List<String>> getDatesAndStreets() {
        return datesAndStreets;
    }

    public void setDatesAndStreets(HashMap<LocalDate, List<String>> datesAndStreets) {
        this.datesAndStreets = datesAndStreets;
    }
}

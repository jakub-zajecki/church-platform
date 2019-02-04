package com.churcher.churchplatform.model;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;

@Entity
public class Mass {

    @Id
    @GeneratedValue
    private Long id;
    private LocalTime massTime;
    private int maxIntesionNum;
    @ManyToOne
    @JoinColumn(name = "CHURCHDAY_ID")
    private ChurchDay churchDay;
    @OneToMany(mappedBy = "mass")
    private List<Intention> intentionList;

    public Long getId() {
        return id;
    }


    public LocalTime getMassTime() {
        return massTime;
    }

    public void setMassTime(LocalTime massTime) {
        this.massTime = massTime;
    }

    public int getMaxIntesionNum() {
        return maxIntesionNum;
    }

    public void setMaxIntesionNum(int maxIntesionNum) {
        this.maxIntesionNum = maxIntesionNum;
    }

    public ChurchDay getChurchDay() {
        return churchDay;
    }

    public void setChurchDay(ChurchDay churchDay) {
        this.churchDay = churchDay;
    }

    public List<Intention> getIntentionList() {
        return intentionList;
    }

    public void setIntentionList(List<Intention> intentionList) {
        this.intentionList = intentionList;
    }
}

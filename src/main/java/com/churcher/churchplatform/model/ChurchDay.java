package com.churcher.churchplatform.model;

import com.churcher.churchplatform.enums.DayType;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class ChurchDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate localDate;
    @OneToMany(mappedBy = "churchDay")
    private List<Mass> massList;
    @Enumerated(EnumType.STRING)
    private DayType dayType;
    private String dayInfo;
    @ManyToOne
    @JoinColumn(name = "CHURCH_ID")
    private Church church;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public List<Mass> getMassList() {
        return massList;
    }

    public void setMassList(List<Mass> massList) {
        this.massList = massList;
    }

    public DayType getDayType() {
        return dayType;
    }

    public void setDayType(DayType dayType) {
        this.dayType = dayType;
    }

    public String getDayInfo() {
        return dayInfo;
    }

    public void setDayInfo(String dayInfo) {
        this.dayInfo = dayInfo;
    }

    public Church getChurch() {
        return church;
    }

    public void setChurch(Church church) {
        this.church = church;
    }
}

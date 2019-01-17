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
    private DayType dayType;
    private String dayInfo;
    @ManyToOne
    @JoinColumn(name = "CALENDAR_ID")
    private Calendar calendar;


}

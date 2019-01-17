package com.churcher.churchplatform.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Calendar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //private Church church;
    @OneToMany(mappedBy = "calendar")
    private List<ChurchDay> churchDayList;
}

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
}

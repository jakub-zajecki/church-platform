package com.churcher.churchplatform.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Church {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String churchName;
    private String parsonName;
    private String officeOpenHours;
    @OneToOne
    @JoinColumn(name = "CHURCHADDRESS_ID")
    private ChurchAddress churchAddress;
    @OneToMany(mappedBy = "church")
    private List<User> userList;
    @OneToOne
    @JoinColumn(name = "CALENDAR_ID")
    private Calendar calendar;
    private BigDecimal minIntencionCost;
}

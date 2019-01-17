package com.churcher.churchplatform.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class UserDay {

    @Id
    @GeneratedValue
    private Long id;
    private LocalDate localDate;
    @OneToMany
    @JoinColumn(name = "INTENTION_ID")
    private List<Intention> userPaidIntencionList;
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

}

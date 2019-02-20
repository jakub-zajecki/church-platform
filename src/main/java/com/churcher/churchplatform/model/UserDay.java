package com.churcher.churchplatform.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class UserDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate localDate;
    @OneToMany(mappedBy = "userDay")
    private List<Intention> userPaidIntencionList;
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

}

package com.churcher.churchplatform.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class IntentionOrder {

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    @JoinColumn(name = "INTENSION_ID")
    private Intention intention;
    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User user;
    private BigDecimal intentionCost;
}

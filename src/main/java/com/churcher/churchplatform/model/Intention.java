package com.churcher.churchplatform.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Intention {

    @Id
    @GeneratedValue
    private Long id;
    private String infoIntention;
    private boolean paid;
    private boolean confirmed;
    private BigDecimal intentionCost;
    @ManyToOne
    @JoinColumn(name = "MASS_ID")
    private Mass mass;

}

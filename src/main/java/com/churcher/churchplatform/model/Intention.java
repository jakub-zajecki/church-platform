package com.churcher.churchplatform.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Intention {

    @Id
    @GeneratedValue
    private Long id;
    private String infoIntencion;
    private boolean paid;
    private boolean confirmed;
    private BigDecimal intencionCost;
    @ManyToOne
    @JoinColumn(name = "MASS_ID")
    private Mass mass;

}

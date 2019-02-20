package com.churcher.churchplatform.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Intention {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String infoIntention;
    private boolean paid;
    private boolean confirmed;
    private BigDecimal intentionCost;
    @ManyToOne
    @JoinColumn(name = "MASS_ID")
    private Mass mass;
    @ManyToOne
    @JoinColumn(name = "USERDAY_ID")
    private UserDay userDay;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInfoIntention() {
        return infoIntention;
    }

    public void setInfoIntention(String infoIntention) {
        this.infoIntention = infoIntention;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public BigDecimal getIntentionCost() {
        return intentionCost;
    }

    public void setIntentionCost(BigDecimal intentionCost) {
        this.intentionCost = intentionCost;
    }

    public Mass getMass() {
        return mass;
    }

    public void setMass(Mass mass) {
        this.mass = mass;
    }

    public UserDay getUserDay() {
        return userDay;
    }

    public void setUserDay(UserDay userDay) {
        this.userDay = userDay;
    }
}

package com.churcher.churchplatform.dto;

import com.churcher.churchplatform.model.Mass;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class IntentionDto {

    private Long id;
    private String infoIntention;
    private boolean paid;
    private boolean confirmed;
    private BigDecimal intentionCost;
    private Mass mass;

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
}

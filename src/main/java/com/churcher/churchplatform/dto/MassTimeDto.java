package com.churcher.churchplatform.dto;

import java.time.LocalTime;

public class MassTimeDto {

    private Long id;
    private LocalTime massTime;
    private int maxIntentionNumber;
    private int createdIntentionsNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getMassTime() {
        return massTime;
    }

    public void setMassTime(LocalTime massTime) {
        this.massTime = massTime;
    }

    public int getMaxIntentionNumber() {
        return maxIntentionNumber;
    }

    public void setMaxIntentionNumber(int maxIntentionNumber) {
        this.maxIntentionNumber = maxIntentionNumber;
    }

    public int getCreatedIntentionsNumber() {
        return createdIntentionsNumber;
    }

    public void setCreatedIntentionsNumber(int createdIntentionsNumber) {
        this.createdIntentionsNumber = createdIntentionsNumber;
    }
}

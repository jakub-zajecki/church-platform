package com.churcher.churchplatform.service;

import com.churcher.churchplatform.model.Intention;

import java.math.BigDecimal;

public interface IntentionService {

    void save(Intention intention);
    Intention createIntention(String intentionText, BigDecimal intentionCost);

}

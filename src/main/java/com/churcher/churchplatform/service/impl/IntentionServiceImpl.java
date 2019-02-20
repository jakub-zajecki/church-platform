package com.churcher.churchplatform.service.impl;

import com.churcher.churchplatform.dao.IntentionRepository;
import com.churcher.churchplatform.dto.IntentionDto;
import com.churcher.churchplatform.model.Intention;
import com.churcher.churchplatform.service.IntentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class IntentionServiceImpl implements IntentionService {

    private IntentionRepository intentionRepository;

    @Autowired
    public IntentionServiceImpl(IntentionRepository intentionRepository) {
        this.intentionRepository = intentionRepository;
    }

    @Override
    public void save(Intention intention) {
        if(intention != null){
            intentionRepository.save(intention);
        }
    }

    @Override
    public Intention createIntention(String intentionText, BigDecimal intentionCost) {
        Intention intention = new Intention();
        intention.setInfoIntention(intentionText);
        intention.setIntentionCost(intentionCost);
        return intention;
    }
}

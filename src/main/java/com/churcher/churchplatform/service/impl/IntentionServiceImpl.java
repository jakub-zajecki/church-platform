package com.churcher.churchplatform.service.impl;

import com.churcher.churchplatform.dao.IntentionRepository;
import com.churcher.churchplatform.dto.IntentionDto;
import com.churcher.churchplatform.model.Intention;
import com.churcher.churchplatform.service.IntentionService;
import org.springframework.beans.factory.annotation.Autowired;

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
}

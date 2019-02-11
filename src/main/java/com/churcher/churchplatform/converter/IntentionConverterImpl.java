package com.churcher.churchplatform.converter;

import com.churcher.churchplatform.dto.IntentionDto;
import com.churcher.churchplatform.model.Intention;
import org.springframework.stereotype.Component;

@Component
public class IntentionConverterImpl implements IntentionConverter {


    @Override
    public Intention convertToIntention(IntentionDto intentionDto) {
        Intention intention = new Intention();
        intention.setId(intention.getId());
        intention.setInfoIntention(intentionDto.getInfoIntention());
        intention.setPaid(intentionDto.isPaid());
        intention.setConfirmed(intentionDto.isConfirmed());
        intention.setIntentionCost(intentionDto.getIntentionCost());
        intention.setMass(intentionDto.getMass());
        return intention;
    }

    @Override
    public IntentionDto convertToIntentionDto(Intention intention) {
        IntentionDto intentionDto = new IntentionDto();
        intentionDto.setId(intention.getId());
        intentionDto.setInfoIntention(intention.getInfoIntention());
        intentionDto.setPaid(intention.isPaid());
        intentionDto.setConfirmed(intention.isConfirmed());
        intentionDto.setIntentionCost(intention.getIntentionCost());
        intentionDto.setMass(intention.getMass());
        return intentionDto;
    }
}

package com.churcher.churchplatform.converter;

import com.churcher.churchplatform.dto.IntentionDto;
import com.churcher.churchplatform.model.Intention;

public interface IntentionConverter {

    Intention convertToIntention(IntentionDto intentionDto);
    IntentionDto convertToIntentionDto(Intention intention);

}

package com.churcher.churchplatform.converter;

import com.churcher.churchplatform.dto.MassTimeDto;
import com.churcher.churchplatform.enums.DayType;
import com.churcher.churchplatform.model.DefaultMassTime;
import com.churcher.churchplatform.model.Mass;
import com.churcher.churchplatform.service.MassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultMassTimeConverterImpl implements DefaultMassTimeConverter{

    private MassService massService;

    @Autowired
    public DefaultMassTimeConverterImpl(MassService massService) {
        this.massService = massService;
    }

    public MassTimeDto defaultMassTimeToMassTimeDto(DefaultMassTime defaultMassTime, Long churchDayId, DayType dayType){

        MassTimeDto massTimeDto = new MassTimeDto();
        massTimeDto.setId(defaultMassTime.getId());
        massTimeDto.setMassTime(defaultMassTime.getMassTime());

        Mass mass = massService.findByMassTimeAndChurchDayId(defaultMassTime.getMassTime(), churchDayId);

        if(dayType == DayType.NORMAL){
            massTimeDto.setMaxIntentionNumber(defaultMassTime.getChurch().getMaxNumNormalChurchDayIntentions());
        } else {
            massTimeDto.setMaxIntentionNumber(defaultMassTime.getChurch().getMaxNumHolidayChurchDayIntentions());
        }

        if(mass == null){
            massTimeDto.setCreatedIntentionsNumber(0);
        } else {
            massTimeDto.setCreatedIntentionsNumber(mass.getIntentionList().size());
        }

        return massTimeDto;
    }


}

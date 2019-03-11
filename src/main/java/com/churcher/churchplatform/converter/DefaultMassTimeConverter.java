package com.churcher.churchplatform.converter;

import com.churcher.churchplatform.dto.MassTimeDto;
import com.churcher.churchplatform.enums.DayType;
import com.churcher.churchplatform.model.DefaultMassTime;

public interface DefaultMassTimeConverter {

    MassTimeDto defaultMassTimeToMassTimeDto(DefaultMassTime defaultMassTime, Long churchDayId, DayType dayType);

}

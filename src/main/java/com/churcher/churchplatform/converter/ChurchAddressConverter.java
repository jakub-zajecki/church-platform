package com.churcher.churchplatform.converter;

import com.churcher.churchplatform.dto.ChurchAddressDto;
import com.churcher.churchplatform.model.ChurchAddress;

public interface ChurchAddressConverter {

    public ChurchAddress convertToChurchAddress(ChurchAddressDto churchAddressDto);
    public ChurchAddressDto convertToChurchAddressDTO(ChurchAddress churchAddress);

}

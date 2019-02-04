package com.churcher.churchplatform.converter;

import com.churcher.churchplatform.dto.ChurchAddressDto;
import com.churcher.churchplatform.model.ChurchAddress;

public class ChurchAddressConverterImpl implements ChurchAddressConverter {
    @Override
    public ChurchAddress convertToChurchAddress(ChurchAddressDto churchAddressDto) {

        ChurchAddress churchAddress = new ChurchAddress();

        churchAddress.setCity(churchAddressDto.getCity());
        churchAddress.setPostalCode(churchAddressDto.getPostalCode());
        churchAddress.setStreet(churchAddressDto.getStreet());
        churchAddress.setHouseNumber(churchAddressDto.getHouseNumber());
        churchAddress.setApartmentNumber(churchAddressDto.getApartmentNumber());

        return churchAddress;
    }

    @Override
    public ChurchAddressDto convertToChurchAddressDTO(ChurchAddress churchAddress) {
        ChurchAddressDto churchAddressDto = new ChurchAddressDto();

        churchAddressDto.setCity(churchAddress.getCity());
        churchAddressDto.setPostalCode(churchAddress.getPostalCode());
        churchAddressDto.setStreet(churchAddress.getStreet());
        churchAddressDto.setHouseNumber(churchAddress.getHouseNumber());
        churchAddressDto.setApartmentNumber(churchAddress.getApartmentNumber());

        return churchAddressDto;
    }
}

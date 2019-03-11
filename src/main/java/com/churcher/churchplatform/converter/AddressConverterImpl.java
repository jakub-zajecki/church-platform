package com.churcher.churchplatform.converter;

import com.churcher.churchplatform.dto.AddressDto;
import com.churcher.churchplatform.model.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressConverterImpl implements AddressConverter {

    @Override
    public Address convertToAddress(AddressDto addressDto) {

        Address address = new Address();
        address.setCity(addressDto.getCity());
        address.setStreet(addressDto.getStreet());
        address.setPostalCode(addressDto.getPostalCode());
        address.setHouseNumber(addressDto.getHouseNumber());
        address.setApartmentNumber(addressDto.getApartmentNumber());

        return address;
    }

    @Override
    public AddressDto convertToAddressDto(Address address) {

        AddressDto addressDto = new AddressDto();
        addressDto.setCity(address.getCity());
        addressDto.setStreet(address.getStreet());
        addressDto.setPostalCode(address.getPostalCode());
        addressDto.setHouseNumber(address.getHouseNumber());
        addressDto.setApartmentNumber(address.getApartmentNumber());

        return addressDto;
    }
}

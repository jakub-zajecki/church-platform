package com.churcher.churchplatform.converter;

import com.churcher.churchplatform.dto.AddressDto;
import com.churcher.churchplatform.model.Address;

public interface AddressConverter {

    public Address convertToAddress(AddressDto addressDto);
    public AddressDto convertToAddressDto(Address address);
}

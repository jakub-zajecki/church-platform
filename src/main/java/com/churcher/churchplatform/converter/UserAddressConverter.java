package com.churcher.churchplatform.converter;

import com.churcher.churchplatform.dto.UserAddressDto;
import com.churcher.churchplatform.model.UserAddress;

public interface UserAddressConverter {

    public UserAddress convertToUserAddress(UserAddressDto userAddressDto);
    public UserAddressDto convertToUserAddressDto(UserAddress userAddress);
}

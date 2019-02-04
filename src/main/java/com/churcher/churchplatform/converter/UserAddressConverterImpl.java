package com.churcher.churchplatform.converter;

import com.churcher.churchplatform.dto.UserAddressDto;
import com.churcher.churchplatform.model.UserAddress;

public class UserAddressConverterImpl implements UserAddressConverter {

    @Override
    public UserAddress convertToUserAddress(UserAddressDto userAddressDto) {

        UserAddress userAddress = new UserAddress();
        userAddress.setCity(userAddressDto.getCity());
        userAddress.setStreet(userAddressDto.getStreet());
        userAddress.setPostalCode(userAddressDto.getPostalCode());
        userAddress.setHouseNumber(userAddressDto.getHouseNumber());
        userAddress.setApartmentNumber(userAddressDto.getApartmentNumber());

        return userAddress;
    }

    @Override
    public UserAddressDto convertToUserAddressDto(UserAddress userAddress) {

        UserAddressDto userAddressDto = new UserAddressDto();
        userAddressDto.setCity(userAddress.getCity());
        userAddressDto.setStreet(userAddress.getStreet());
        userAddressDto.setPostalCode(userAddress.getPostalCode());
        userAddressDto.setHouseNumber(userAddress.getHouseNumber());
        userAddressDto.setApartmentNumber(userAddress.getApartmentNumber());

        return userAddressDto;
    }
}

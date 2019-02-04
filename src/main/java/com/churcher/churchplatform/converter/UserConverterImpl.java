package com.churcher.churchplatform.converter;

import com.churcher.churchplatform.dto.UserDto;
import com.churcher.churchplatform.enums.UserRole;
import com.churcher.churchplatform.model.ChurchAddress;
import com.churcher.churchplatform.model.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;


public class UserConverterImpl implements UserConverter {

    private UserAddressConverter userAddressConverter;
    private ChurchAddressConverter churchAddressConverter;


    @Autowired
    public UserConverterImpl(UserAddressConverter userAddressConverter, ChurchAddressConverter churchAddressConverter) {
        this.userAddressConverter = userAddressConverter;
        this.churchAddressConverter = churchAddressConverter;
    }

    @Override
    public User convertToUser(UserDto userDto) {

        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setLogin(userDto.getLogin());
        user.setMail(userDto.getMail());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setPassword(DigestUtils.md5Hex(userDto.getPassword()));
        user.setToken(UUID.randomUUID().toString());

//        if(userDto.getUserRole()== UserRole.CHURCH_ADMIN){
//            user.setUserAddress(userAddressConverter.convertToUserAddress(userDto.getUserDtoAddress()));
//        }
//        user.setUserAddress(u);

        user.setUserAddress(userAddressConverter.convertToUserAddress(userDto.getUserAddressDto()));

        return user;
    }

    @Override
    public UserDto convertToUserDto(User user) {

        UserDto userDto = new UserDto();

        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());

        return userDto;
    }
}

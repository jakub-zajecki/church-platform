package com.churcher.churchplatform.converter;

import com.churcher.churchplatform.dto.UserDto;
import com.churcher.churchplatform.model.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class UserConverterImpl implements UserConverter {

    private AddressConverter addressConverter;


    @Autowired
    public UserConverterImpl(AddressConverter addressConverterter) {
        this.addressConverter = addressConverter;
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

        user.setAddress(addressConverter.convertToAddress(userDto.getddressDto()));

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

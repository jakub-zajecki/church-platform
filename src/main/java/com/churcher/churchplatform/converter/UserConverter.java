package com.churcher.churchplatform.converter;

import com.churcher.churchplatform.dto.UserDto;
import com.churcher.churchplatform.model.User;

public interface UserConverter {

    public User convertToUser(UserDto userDto);
    public UserDto convertToUserDto(User user);
}

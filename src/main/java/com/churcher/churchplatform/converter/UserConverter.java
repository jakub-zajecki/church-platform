package com.churcher.churchplatform.converter;

import com.churcher.churchplatform.dto.UserDto;
import com.churcher.churchplatform.model.User;

import java.util.List;

public interface UserConverter {

    public User convertToUser(UserDto userDto);
    public UserDto convertToUserDto(User user);
    public List<UserDto> convertToUsersDtoList(List<User> users);
}

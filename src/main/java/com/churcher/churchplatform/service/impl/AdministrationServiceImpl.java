package com.churcher.churchplatform.service.impl;

import com.churcher.churchplatform.converter.UserConverter;
import com.churcher.churchplatform.dto.UserDto;
import com.churcher.churchplatform.enums.UserStatus;
import com.churcher.churchplatform.model.User;
import com.churcher.churchplatform.service.AdministrationService;
import com.churcher.churchplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministrationServiceImpl implements AdministrationService {

  private UserService userService;
  private UserConverter userConverter;

    @Autowired
    public AdministrationServiceImpl(UserService userService, UserConverter userConverter) {
        this.userService = userService;
        this.userConverter = userConverter;
    }

    @Override
    public List<UserDto> getNewUsers() {

        return userConverter.convertToUsersDtoList(userService.findUsersByUserStatus(UserStatus.NEW));
    }

    @Override
    public List<UserDto> getConfirmedUsers() {
        return userConverter.convertToUsersDtoList(userService.findUsersByUserStatus(UserStatus.CONFIRMED));
    }

    @Override
    public List<UserDto> getActivatedUsers() {
        return userConverter.convertToUsersDtoList(userService.findUsersByUserStatus(UserStatus.ACTIVATED));
    }

    @Override
    public boolean setUserStatusActivated(String login, boolean choice) {

        Optional<User> user = userService.findUserByLogin(login);
        if(user.isPresent()){
            User userActivated = user.get();
            userActivated.setUserStatus(UserStatus.ACTIVATED);
            return true;
        }

        return false;
    }
}

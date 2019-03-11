package com.churcher.churchplatform.dto;

import com.churcher.churchplatform.enums.UserRole;
import org.springframework.security.core.authority.AuthorityUtils;

import javax.management.relation.Role;

public class LoggedUser extends org.springframework.security.core.userdetails.User {

    private UserDto userDto;

    public LoggedUser(UserDto userDto){
        super(userDto.getMail(), userDto.getPassword(), AuthorityUtils.createAuthorityList(userDto.getUserRole().toString()));
        this.userDto = userDto;
    }

    public UserDto getUser() {
        return userDto;
    }


    public UserRole getRole() {
        return userDto.getUserRole();
    }
}

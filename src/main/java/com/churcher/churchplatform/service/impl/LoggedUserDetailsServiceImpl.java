package com.churcher.churchplatform.service.impl;

import com.churcher.churchplatform.converter.UserConverter;
import com.churcher.churchplatform.dto.LoggedUser;
import com.churcher.churchplatform.dto.UserDto;
import com.churcher.churchplatform.model.User;
import com.churcher.churchplatform.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoggedUserDetailsServiceImpl implements UserDetailsService {

    private UserService userService;
    private UserConverter userConverter;

    public LoggedUserDetailsServiceImpl(UserService userService, UserConverter userConverter) {
        this.userService = userService;
        this.userConverter = userConverter;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userService.findFirstByLogin(login)
                 .orElseThrow(() -> new UsernameNotFoundException(String.format("User with email=%s was not found", login)));

        return new LoggedUser(userConverter.convertToUserDto(user));
    }
}

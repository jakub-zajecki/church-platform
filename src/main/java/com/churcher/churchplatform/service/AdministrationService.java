package com.churcher.churchplatform.service;

import com.churcher.churchplatform.dto.UserDto;

import java.util.List;

public interface AdministrationService {

public List<UserDto> getNewUsers();

public List<UserDto> getConfirmedUsers();

public List<UserDto> getActivatedUsers();

public boolean setUserStatusActivated(String login,boolean choice);

}

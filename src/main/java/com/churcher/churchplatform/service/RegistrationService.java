package com.churcher.churchplatform.service;

import com.churcher.churchplatform.dto.ChurchRegistrationDto;

public interface RegistrationService {

    public void registerChurch(ChurchRegistrationDto churchRegistrationDto);

    public void registerUser(ChurchRegistrationDto churchRegistrationDto);

    public boolean confirmChurch(String tokenUser,String tokenChurch);

    public boolean activateUser(String login, String password);

    public boolean authenticateUser(String login, String password);
}

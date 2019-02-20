package com.churcher.churchplatform.service;

import com.churcher.churchplatform.model.User;

public interface UserService {

    public void saveUser(User user);

    public User findUserByLogin(String login);

    public User findUserByToken(String token);
}

package com.churcher.churchplatform.service;

import com.churcher.churchplatform.enums.UserStatus;
import com.churcher.churchplatform.model.User;


import java.util.List;
import java.util.Optional;

public interface UserService {

    public void saveUser(User user);

    public Optional<User> findUserByLogin(String login);

    public User findUserByToken(String token);

    public Optional<User> findFirstByLogin(String login);

    public boolean authenticate(String login, String password);

    public User findFirstByMail(String mail);

    public List<User> findUsersByUserStatus(UserStatus userStatus);


}

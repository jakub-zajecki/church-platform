package com.churcher.churchplatform.service.impl;

import com.churcher.churchplatform.dao.UserRepository;
import com.churcher.churchplatform.enums.UserStatus;
import com.churcher.churchplatform.model.User;
import com.churcher.churchplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

   private UserRepository userRepository;

   @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> findUserByLogin(String login) {
        return userRepository.findUserByLogin(login);
    }

    @Override
    public User findUserByToken(String token) {
        return userRepository.findUserByToken(token);
    }

    @Override
    public Optional<User> findFirstByLogin(String login) {
        return userRepository.findFirstByLogin(login);
    }

    @Override
    public boolean authenticate(String login, String password) {
        return userRepository.findUserByLoginAndPasswordAndUserStatus(
                login, password, UserStatus.ACTIVATED) != null;
    }

    @Override
    public User findFirstByMail(String mail) {
        return userRepository.findFirstByMail(mail);
    }

    @Override
    public List<User> findUsersByUserStatus(UserStatus userStatus) {
        return userRepository.findUsersByUserStatus(userStatus);
    }


}

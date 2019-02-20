package com.churcher.churchplatform.service.impl;

import com.churcher.churchplatform.dao.UserRepository;
import com.churcher.churchplatform.model.User;
import com.churcher.churchplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public User findUserByLogin(String login) {
        return userRepository.findUserByLogin(login);
    }

    @Override
    public User findUserByToken(String token) {
        return userRepository.findUserByToken(token);
    }


}

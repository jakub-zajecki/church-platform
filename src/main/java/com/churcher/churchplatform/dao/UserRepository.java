package com.churcher.churchplatform.dao;


import com.churcher.churchplatform.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {

    public User findUserByToken(String token);

    public User findUserByLogin(String login);

}

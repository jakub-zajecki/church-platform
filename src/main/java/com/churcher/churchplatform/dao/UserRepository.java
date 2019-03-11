package com.churcher.churchplatform.dao;


import com.churcher.churchplatform.enums.UserStatus;
import com.churcher.churchplatform.model.User;
import org.springframework.data.repository.CrudRepository;


import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long> {

    public User findUserByToken(String token);

    public Optional<User> findUserByLogin(String login);

    public Optional<User> findFirstByLogin(String login);

    public User findFirstByMail(String mail);

    public User findUserByLoginAndPasswordAndUserStatus(String login, String password, UserStatus userStatus);

    public List<User> findUsersByUserStatus(UserStatus userStatus);



}

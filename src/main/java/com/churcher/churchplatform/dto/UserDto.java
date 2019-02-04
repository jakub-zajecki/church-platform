package com.churcher.churchplatform.dto;

import com.churcher.churchplatform.enums.UserRole;
import com.churcher.churchplatform.enums.UserStatus;
import com.churcher.churchplatform.model.Church;
import com.churcher.churchplatform.model.UserAddress;
import com.churcher.churchplatform.model.UserDay;

import java.util.List;

public class UserDto {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String mail;
    private String login;
    private String password;
    private String token;
    private UserRole userRole;
    private UserStatus userStatus;
    private UserAddress userAddress;
    private List<UserDay> userDayList;
    private Church church;

    public UserDto(){}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String secondName) {
        this.lastName = lastName;
    }


    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public UserAddress getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(UserAddress userAddress) {
        this.userAddress = userAddress;
    }

    public List<UserDay> getUserDayList() {
        return userDayList;
    }

    public void setUserDayList(List<UserDay> userDayList) {
        this.userDayList = userDayList;
    }

    public Church getChurch() {
        return church;
    }

    public void setChurch(Church church) {
        this.church = church;
    }
}

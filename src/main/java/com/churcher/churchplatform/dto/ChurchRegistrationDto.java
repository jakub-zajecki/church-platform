package com.churcher.churchplatform.dto;

public class ChurchRegistrationDto {

    private String churchName;
    private String parsonName;

    private String churchStreet;
    private int churchBuildingNumber;
    private String postalCode;
    private String city;

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String mail;
    private String login;
    private String password;
    private String matchingPassword;
    private String token;

    public ChurchRegistrationDto(){}

    public String getChurchName() {
        return churchName;
    }

    public void setChurchName(String churchName) {
        this.churchName = churchName;
    }

    public String getParsonName() {
        return parsonName;
    }

    public void setParsonName(String parsonName) {
        this.parsonName = parsonName;
    }

    public String getChurchStreet() {
        return churchStreet;
    }

    public void setChurchStreet(String churchStreet) {
        this.churchStreet = churchStreet;
    }

    public int getChurchBuildingNumber() {
        return churchBuildingNumber;
    }

    public void setChurchBuildingNumber(int churchbuildingNumber) {
        this.churchBuildingNumber = churchbuildingNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }
}

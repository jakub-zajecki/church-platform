package com.churcher.churchplatform.service;

public interface EmailService {

    public void sendRegistrationMessage(String to, String subject, String text);
}

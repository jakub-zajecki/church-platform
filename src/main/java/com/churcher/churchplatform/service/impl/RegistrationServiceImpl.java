package com.churcher.churchplatform.service.impl;

import com.churcher.churchplatform.dto.ChurchRegistrationDto;
import com.churcher.churchplatform.enums.ChurchStatus;
import com.churcher.churchplatform.enums.UserStatus;
import com.churcher.churchplatform.model.Address;
import com.churcher.churchplatform.model.Church;
import com.churcher.churchplatform.model.User;
import com.churcher.churchplatform.service.ChurchService;
import com.churcher.churchplatform.service.EmailService;
import com.churcher.churchplatform.service.RegistrationService;
import com.churcher.churchplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Locale;
import java.util.UUID;


@Service
public class RegistrationServiceImpl implements RegistrationService {

    private UserService userService;
    private ChurchService churchService;
    private EmailService emailService;
    private MessageSource messageSource;

    @Autowired
    public RegistrationServiceImpl(UserService userService, ChurchService churchService, EmailService emailService, MessageSource messageSource) {
        this.userService = userService;
        this.churchService = churchService;
        this.emailService = emailService;
        this.messageSource = messageSource;
    }

    @Override
    public void registerChurch(ChurchRegistrationDto churchRegistrationDto) {

        Address address = new Address();
        address.setStreet(churchRegistrationDto.getChurchStreet());
        address.setHouseNumber(churchRegistrationDto.getChurchBuildingNumber());
        address.setCity(churchRegistrationDto.getCity());
        address.setPostalCode(churchRegistrationDto.getPostalCode());

        User user = new User();
        user.setFirstName(churchRegistrationDto.getFirstName());
        user.setLastName(churchRegistrationDto.getLastName());
        user.setMail(churchRegistrationDto.getMail());
        user.setPassword(DigestUtils.md5Hex(churchRegistrationDto.getPassword()));
        user.setToken(UUID.randomUUID().toString());
        user.setUserStatus(UserStatus.NEW);

        Church church = new Church();
        church.setChurchName(churchRegistrationDto.getChurchName());
        church.setParsonName(churchRegistrationDto.getParsonName());
        church.setChurchStatus(ChurchStatus.NEW);
        church.setChurchToken(UUID.randomUUID().toString());
        church.setAddress(address);
        church.setUserList(new ArrayList<>());
        church.getUserList().add(user);

        userService.saveUser(user);
        churchService.saveChurch(church);

        String confirmationTitle = messageSource.getMessage("mail.church.confirmation.title", new Object[] {
                church.getChurchName()}, Locale.getDefault());

        String mailText = messageSource.getMessage("mail.church.confirmation.text", new Object[] {
                church.getChurchName(),user.getToken(),church.getChurchToken()}, Locale.getDefault());

        emailService.sendRegistrationMessage(user.getMail(), confirmationTitle, mailText);


    }

    @Override
    public void registerUser(ChurchRegistrationDto churchRegistrationDto) {

    }

    @Override
    public boolean confirmChurch(String tokenUser,String tokenChurch) {
        Church church = churchService.findChurchByToken(tokenChurch);
        User user = userService.findUserByToken(tokenUser);
        if (church!=null&& church.getChurchStatus().equals(ChurchStatus.NEW) && user!=null&& user.getUserStatus().equals(UserStatus.NEW)) {
            church.setChurchStatus(ChurchStatus.CONFIRMED);
            churchService.saveChurch(church);
            user.setUserStatus(UserStatus.CONFIRMED);
            userService.saveUser(user);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean activateUser(String login, String password) {
        return false;
    }

    @Override
    public boolean authenticateUser(String login, String password) {
        return false;
    }
}

package com.churcher.churchplatform.controller;

import com.churcher.churchplatform.dto.ChurchRegistrationDto;
import com.churcher.churchplatform.service.ChurchService;
import com.churcher.churchplatform.service.RegistrationService;
import com.churcher.churchplatform.service.UserService;
import com.churcher.churchplatform.validators.ChurchValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Locale;

@Controller
public class RegistrationController {

    private ChurchService churchService;
    private UserService userService;
    private ChurchValidator churchValidator;
    private MessageSource messageSource;
    private RegistrationService registrationService;

    @Autowired
    public RegistrationController(ChurchService churchService, UserService userService, ChurchValidator churchValidator, MessageSource messageSource,RegistrationService registrationService) {
        this.churchService = churchService;
        this.userService = userService;
        this.churchValidator = churchValidator;
        this.messageSource = messageSource;
        this.registrationService = registrationService;
    }

    @InitBinder("churchDto")
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(churchValidator);
    }

    @GetMapping("/church-registration")
    public String registerCustomer(Model model) {
        model.addAttribute("churchDto", new ChurchRegistrationDto());
        return "church-registration";
    }


    @PostMapping("/church-registration")
    public String registerCustomer(@Valid @ModelAttribute("churchDto")  ChurchRegistrationDto churchRegistrationDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "church-registration";
        }
        registrationService.registerChurch(churchRegistrationDto);
        model.addAttribute("message", messageSource.getMessage("church.registered",new Object[] {churchRegistrationDto.getMail()}, Locale.getDefault() ));
        return "church-register-message";
    }
}

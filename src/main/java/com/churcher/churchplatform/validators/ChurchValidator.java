package com.churcher.churchplatform.validators;

import com.churcher.churchplatform.dao.ChurchRepository;
import com.churcher.churchplatform.dao.UserRepository;
import com.churcher.churchplatform.dto.ChurchRegistrationDto;
import com.churcher.churchplatform.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;
import java.util.regex.Pattern;

@Component
public class ChurchValidator implements Validator {

    private ChurchRepository churchRepository;
    private UserRepository userRepository;

    @Autowired
    public ChurchValidator(ChurchRepository churchRepository, UserRepository userRepository) {
        this.churchRepository = churchRepository;
        this.userRepository = userRepository;
    }

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


    private static final String LOGIN_PATTERN = "[a-zA-Z0-9]{5,}";

    private static final String PHONE_PATTERN = "^(?:\\(?\\+?48)?(?:[-\\.\\(\\)\\s]*(\\d)){9}\\)?$";

    private static final String POST_CODE_PATTERN = "\\d{2}-\\d{3}";

    private static final String STREET_NAME_PATTERN = "^[A-zęóąśłżźćńĘÓĄŚŁŻŹĆŃ\\s]*$";


    @Override
    public boolean supports(Class<?> aClass) {
        return ChurchRegistrationDto.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        ChurchRegistrationDto churchRegistrationDto = (ChurchRegistrationDto) o;
        Optional<User> userlogin = userRepository.findFirstByLogin(churchRegistrationDto.getLogin());
        User usermail = userRepository.findFirstByMail(churchRegistrationDto.getMail());


        if (StringUtils.isEmpty(churchRegistrationDto.getChurchName())) {
            errors.rejectValue("churchName", "empty.church.name.message");
        }
        if(StringUtils.isEmpty(churchRegistrationDto.getChurchStreet())) {
            errors.rejectValue("churchStreet", "empty.church.street.message");
        }

        if(StringUtils.isEmpty(churchRegistrationDto.getParsonName())) {
            errors.rejectValue("churchParsonName", "empty.church.parson.name.message");
        }
        Pattern emailPattern = Pattern.compile(EMAIL_PATTERN,
                Pattern.CASE_INSENSITIVE);
        Pattern loginPattern = Pattern.compile(LOGIN_PATTERN,
                Pattern.CASE_INSENSITIVE);
        Pattern phonePattern = Pattern.compile(PHONE_PATTERN,
                Pattern.CASE_INSENSITIVE);
        Pattern postCode = Pattern.compile(POST_CODE_PATTERN,
                Pattern.CASE_INSENSITIVE);
        Pattern streetName = Pattern.compile(STREET_NAME_PATTERN,
                Pattern.CASE_INSENSITIVE);


        if (!(loginPattern.matcher(churchRegistrationDto.getLogin()).matches())) {
            errors.rejectValue("login", "wrong.login.format");
        }
        if (userlogin.isPresent()) {
            errors.rejectValue("login", "login.exist.message");
        }

        if (usermail != null) {
            errors.rejectValue("mail", "email.exist.message");
        }
        if (!churchRegistrationDto.getPassword().equals(churchRegistrationDto.getMatchingPassword())) {
            errors.rejectValue("matchingPassword", "no.matching.password.message");
        }
        if (!(phonePattern.matcher(churchRegistrationDto.getPhoneNumber()).matches())) {
            errors.rejectValue("phoneNumber", "wrong.phone.number.format");
        }
        if (!(emailPattern.matcher(churchRegistrationDto.getMail()).matches())) {
            errors.rejectValue("mail", "wrong.email.format");
        }
        if (!(postCode.matcher(churchRegistrationDto.getPostalCode()).matches())) {
            errors.rejectValue("postalCode", "wrong.post.code.format");
        }
        if (!(streetName.matcher(churchRegistrationDto.getChurchStreet()).matches())) {
            errors.rejectValue("churchStreet", "wrong.street.name.format");
        }
    }
}

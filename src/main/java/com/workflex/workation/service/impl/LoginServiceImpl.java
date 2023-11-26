package com.workflex.workation.service.impl;

import com.workflex.workation.exception.EmailDoesNotValidate;
import com.workflex.workation.model.dto.request.LoginRequestDto;
import com.workflex.workation.model.dto.response.LoginResponseDto;
import com.workflex.workation.service.LoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    private static final String EXAMPLE_EMAIL_DOMAIN = "@example.com";

    @Override
    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        checkEmailValidation(loginRequestDto.email());
        return new LoginResponseDto("logged in successfully", loginRequestDto.email());
    }

    private void checkEmailValidation(String email) {
        if (email.endsWith(EXAMPLE_EMAIL_DOMAIN)) {
            throw new EmailDoesNotValidate("invalid_email",
                    "emails from example.com are not allowed");
        }
    }
}

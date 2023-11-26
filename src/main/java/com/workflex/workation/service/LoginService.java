package com.workflex.workation.service;

import com.workflex.workation.model.dto.request.LoginRequestDto;
import com.workflex.workation.model.dto.response.LoginResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    public LoginResponseDto login(LoginRequestDto loginRequestDto);
}

package com.workflex.workation.controller.auth;

import com.workflex.workation.model.dto.request.LoginRequestDto;
import com.workflex.workation.model.dto.response.LoginResponseDto;
import com.workflex.workation.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/workflex")
@CrossOrigin
@RequiredArgsConstructor
@Slf4j
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(
            @RequestBody @Validated LoginRequestDto loginRequestDto) {
        log.info("login with email {}", loginRequestDto.email());
        return ResponseEntity.ok(loginService.login(loginRequestDto));
    }
}

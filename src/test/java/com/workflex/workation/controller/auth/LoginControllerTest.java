package com.workflex.workation.controller.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.workflex.workation.model.dto.request.LoginRequestDto;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testEmptyEmailOrPassword() throws Exception {
        LoginRequestDto requestDto = new LoginRequestDto("", "");
        String requestBody = objectMapper.writeValueAsString(requestDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/workflex/login")
                        .content(requestBody)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message", Matchers.is("validation_error")))
                .andExpect(jsonPath("$.details", Matchers.containsInAnyOrder(
                        "password should not be empty",
                        "email should not be empty"
                )))
                .andExpect(jsonPath("$.timestamp").exists());
    }

    @Test
    void testInvalidEmail() throws Exception {
        LoginRequestDto requestDto = new LoginRequestDto("invalid_email", "password");
        String requestBody = objectMapper.writeValueAsString(requestDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/workflex/login")
                        .content(requestBody)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message", Matchers.is("validation_error")))
                .andExpect(jsonPath("$.details", Matchers.containsInAnyOrder(
                        "email should be in valid format"
                )))
                .andExpect(jsonPath("$.timestamp").exists());
    }

    @Test
    void testExampleDotComEmail() throws Exception {
        LoginRequestDto requestDto = new LoginRequestDto("ahmed@example.com", "password");
        String requestBody = objectMapper.writeValueAsString(requestDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/workflex/login")
                        .content(requestBody)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message", Matchers.is("invalid_email")))
                .andExpect(jsonPath("$.details", Matchers.containsInAnyOrder(
                        "emails from example.com are not allowed"
                )))
                .andExpect(jsonPath("$.timestamp").exists());
    }

    @Test
    void testLoginSuccessfully() throws Exception {
        LoginRequestDto requestDto = new LoginRequestDto(
                "ahmed@getworkflex.com",
                "password");
        String requestBody = objectMapper.writeValueAsString(requestDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/workflex/login")
                        .content(requestBody)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message", Matchers.is("logged in successfully")))
                .andExpect(jsonPath("$.email", Matchers.is(requestDto.email())));
    }
}
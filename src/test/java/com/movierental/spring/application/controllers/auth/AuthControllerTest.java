package com.movierental.spring.application.controllers.auth;

import com.movierental.spring.configuration.SecurityConfig;
import com.movierental.spring.configuration.token.TokenService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest({AuthController.class})
@Import({SecurityConfig.class, TokenService.class})
@RequiredArgsConstructor
class AuthControllerTest {

    private final static String USERNAME = "testuser";
    private final static String PASSWORD = "password1";


    @Autowired
    MockMvc mockMvc;

    @Test
    void rootWhenUnauthenticatedThen401() throws Exception {
        this.mockMvc.perform(get("/"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void rootWhenAuthenticatedThenSaysHelLo() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(post("/api/v1/auth/token")
                        .with(httpBasic(USERNAME, PASSWORD)))
                .andExpect(status().isOk())
                .andReturn();

        String token = mvcResult.getResponse().getContentAsString();

        this.mockMvc.perform(get("/api/v1/auth")
                        .header("Authorization", "Bearer " + token))
                .andExpect(content().string(USERNAME));
    }

    @Test
    @WithMockUser
    void rootWithMockUserStatusIsOk() throws Exception {
        this.mockMvc.perform(get("/api/v1/auth"))
                .andExpect(status().isOk());
    }
}
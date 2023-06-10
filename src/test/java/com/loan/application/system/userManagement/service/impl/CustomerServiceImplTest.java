package com.loan.application.system.userManagement.service.impl;

import com.loan.application.system.userManagement.data.dto.Request.RegisterRequest;
import com.loan.application.system.userManagement.data.dto.Response.RegisterResponse;
import com.loan.application.system.userManagement.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class CustomerServiceImplTest {
@Autowired
private CustomerService customerService;
private RegisterRequest request;
    @BeforeEach
    void setUp() throws IOException {
        request = new RegisterRequest();
        request.setFullName("John Doe");
        request.setEmail("test@Email.com");
        request.setPassword("testPassword");
    }

    @Test
    void registerTest() {
        RegisterResponse registerResponse = customerService.register(request);
        assertThat(registerResponse).isNotNull();
    }
}
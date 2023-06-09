package com.loan.application.system.userManagement.service.impl;

import com.loan.application.system.userManagement.data.dto.Register.LoginResponse;
import com.loan.application.system.userManagement.data.dto.Register.RegisterResponse;
import com.loan.application.system.userManagement.data.dto.Request.LoginRequest;
import com.loan.application.system.userManagement.data.dto.Request.RegisterRequest;
import com.loan.application.system.userManagement.data.repository.CustomerRepository;
import com.loan.application.system.userManagement.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    @Override
    public RegisterResponse register(RegisterRequest registerDto) {

        return null;
    }

    @Override
    public LoginResponse login(LoginRequest loginDto) {
        return null;
    }
}

package com.loan.application.system.userManagement.service.impl;

import com.loan.application.system.userManagement.data.dto.Response.LoginResponse;
import com.loan.application.system.userManagement.data.dto.Response.RegisterResponse;
import com.loan.application.system.userManagement.data.dto.Request.LoginRequest;
import com.loan.application.system.userManagement.data.dto.Request.RegisterRequest;
import com.loan.application.system.userManagement.data.model.Customer;
import com.loan.application.system.userManagement.data.model.Roles;
import com.loan.application.system.userManagement.data.model.User;
import com.loan.application.system.userManagement.data.repository.CustomerRepository;
import com.loan.application.system.userManagement.data.repository.UserRepository;
import com.loan.application.system.userManagement.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final UserRepository userRepository;
    @Override
    public RegisterResponse register(RegisterRequest registerDto) {
        User customerDetails = User.builder()
                .fullName(registerDto.getFullName())
                .email(registerDto.getEmail())
                .password(registerDto.getPassword())
                .roles(Set.of(Roles.USER))
                .isEnabled(true)
                .build();
        Customer customer = new Customer();
        customer.setGender(registerDto.getGender());
        customer.setPhoneNumber(registerDto.getPhoneNumber());
        customer.setUserDetails(customerDetails);
        Customer savedCustomer = customerRepository.save(customer);
        return getRegisterResponse(savedCustomer);

    }

    private RegisterResponse getRegisterResponse(Customer savedCustomer) {
        RegisterResponse registerResponse = new RegisterResponse();
        registerResponse.setId(savedCustomer.getId());
        registerResponse.setMessage("customer has successfully register");
        registerResponse.setSuccess(true);
        return registerResponse;
    }

    @Override
    public LoginResponse login(LoginRequest loginDto) {

        return null;
    }
}

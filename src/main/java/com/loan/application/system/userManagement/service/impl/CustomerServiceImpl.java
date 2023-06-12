package com.loan.application.system.userManagement.service.impl;

import com.loan.application.system.userManagement.data.dto.Response.RegisterResponse;
import com.loan.application.system.userManagement.data.dto.Request.RegisterRequest;
import com.loan.application.system.userManagement.data.model.Customer;
import com.loan.application.system.userManagement.data.model.Role;
import com.loan.application.system.userManagement.data.model.User;
import com.loan.application.system.userManagement.data.repository.CustomerRepository;
import com.loan.application.system.userManagement.data.repository.UserRepository;
import com.loan.application.system.userManagement.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    @Override
    public RegisterResponse register(RegisterRequest registerDto) {
        User customerDetails = User.builder()
                .fullName(registerDto.getFullName())
                .email(registerDto.getEmail())
                .password(passwordEncoder.encode(registerDto.getPassword()))
                .roles(Set.of(Role.CUSTOMER))
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
        registerResponse.setMessage("customer has successfully registered");
        registerResponse.setSuccess(true);
        return registerResponse;
    }


}

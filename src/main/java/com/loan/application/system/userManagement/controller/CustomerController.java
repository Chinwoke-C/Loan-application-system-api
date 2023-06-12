package com.loan.application.system.userManagement.controller;

import com.loan.application.system.userManagement.data.dto.Request.RegisterRequest;
import com.loan.application.system.userManagement.data.dto.Response.RegisterResponse;
import com.loan.application.system.userManagement.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/register")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
@PostMapping()
@Operation(summary = "To register customer")
    ResponseEntity<RegisterResponse> registerCustomer(@RequestBody @Valid RegisterRequest registerRequest){
        RegisterResponse registerResponse = customerService.register(registerRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(registerResponse);
    }

}

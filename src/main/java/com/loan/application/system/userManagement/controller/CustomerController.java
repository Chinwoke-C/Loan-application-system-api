package com.loan.application.system.userManagement.controller;

import com.loan.application.system.userManagement.data.dto.Request.LoginRequest;
import com.loan.application.system.userManagement.data.dto.Request.RegisterRequest;
import com.loan.application.system.userManagement.data.dto.Response.LoginResponse;
import com.loan.application.system.userManagement.data.dto.Response.RegisterResponse;
import com.loan.application.system.userManagement.data.model.Role;
import com.loan.application.system.userManagement.service.CustomerService;
import com.loan.application.system.userManagement.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import jakarta.websocket.server.ServerEndpoint;
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
    private final UserService userService;
@PostMapping()
@Operation(summary = "To register customer")
    ResponseEntity<RegisterResponse> registerCustomer(@RequestBody @Valid RegisterRequest registerRequest){
        RegisterResponse registerResponse = customerService.register(registerRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(registerResponse);
    }
@PostMapping("/login")
@Operation(
        summary = "Login",
        description = "If email and password are correct, it returns an access and refresh token"
)
    public ResponseEntity<LoginResponse>customerLogin(
        @Parameter(
            name = "CustomerLoginRequest",
            description = "Email address and password of the customer",
            required = true
            )
            @RequestBody @Valid LoginRequest loginRequest) {
    LoginResponse response = userService.login(loginRequest);
    return ResponseEntity.status(HttpStatus.OK).body(response);
}

}

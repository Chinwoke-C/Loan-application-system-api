package com.loan.application.system.userManagement.service;

import com.loan.application.system.userManagement.data.dto.Response.LoginResponse;
import com.loan.application.system.userManagement.data.dto.Response.RegisterResponse;
import com.loan.application.system.userManagement.data.dto.Request.LoginRequest;
import com.loan.application.system.userManagement.data.dto.Request.RegisterRequest;

public interface CustomerService {
RegisterResponse register(RegisterRequest registerDto);

LoginResponse login(LoginRequest loginDto);


}

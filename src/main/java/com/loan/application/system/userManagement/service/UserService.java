package com.loan.application.system.userManagement.service;

import com.loan.application.system.userManagement.data.dto.Request.LoginRequest;
import com.loan.application.system.userManagement.data.dto.Response.LoginResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface UserService {
    LoginResponse login(LoginRequest requestDto);
    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;
}

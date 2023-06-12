package com.loan.application.system.userManagement.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface UserService {
    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;
}

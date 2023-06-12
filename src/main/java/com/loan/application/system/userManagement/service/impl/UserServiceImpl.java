package com.loan.application.system.userManagement.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.loan.application.system.userManagement.data.dto.Response.LoginResponse;
import com.loan.application.system.userManagement.data.model.User;
import com.loan.application.system.userManagement.data.repository.UserRepository;
import com.loan.application.system.userManagement.service.UserService;
import com.loan.application.system.utilities.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.loan.application.system.exceptions.userManagement.UserNotFoundException;

import java.io.IOException;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.loan.application.system.utilities.Constants.BEARER;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final JwtUtils jwtUtils;
    private final UserRepository userRepository;
    @Override
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final String authHeader = request.getHeader(AUTHORIZATION);
        if (!StringUtils.hasText(authHeader) ||
                !StringUtils.startsWithIgnoreCase(authHeader, BEARER)) return;
        final String token = authHeader.substring(BEARER.length());
        if (jwtUtils.validateToken(token)) {
            final String email = jwtUtils.extractUsername(token);
            if (StringUtils.hasText(email)) {
                User user = getUserByEmail(email);
                final String accessToken = jwtUtils.generateAccessToken(
                        getUserAuthority(user),
                        user.getEmail()
                );
                LoginResponse loginResponse =
                        LoginResponse.builder()
                                .accessToken(accessToken)
                                .refreshToken(token)
                                .build();

                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                new ObjectMapper()
                        .writeValue(
                                response.getOutputStream(),
                                loginResponse
                        );
            }
        }
    }

    private User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(UserNotFoundException::new);
    }
    private static Map<String, Object> getUserAuthority(User savedUser) {
        return savedUser.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.name()))
                .collect(
                        Collectors.toMap(
                                authority -> "claim",
                                Function.identity()
                        )
                );
    }

}


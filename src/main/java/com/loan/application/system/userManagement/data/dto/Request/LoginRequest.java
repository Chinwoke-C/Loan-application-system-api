package com.loan.application.system.userManagement.data.dto.Request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.loan.application.system.utilities.Constants.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    @NotBlank(message = EMAIL_REQUIRED)
    @Email(message = INVALID_EMAIL)
    private String email;
    @NotBlank(message = PASSWORD_REQUIRED)
    private String password;
}

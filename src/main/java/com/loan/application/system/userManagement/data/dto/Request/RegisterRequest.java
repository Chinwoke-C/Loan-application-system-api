package com.loan.application.system.userManagement.data.dto.Request;

import com.loan.application.system.userManagement.data.model.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import static com.loan.application.system.utilities.Constants.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class RegisterRequest {



    @NotBlank(message = FULL_NAME_IS_REQUIRED)
    private String fullName;

    @NotBlank(message = EMAIL_REQUIRED)
    @Email(message = INVALID_EMAIL)
    private String email;

    @NotBlank(message = PASSWORD_REQUIRED)
    private String password;
    private Gender gender;
    private String phoneNumber;
}

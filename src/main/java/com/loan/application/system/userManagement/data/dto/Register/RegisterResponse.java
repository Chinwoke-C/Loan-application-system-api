package com.loan.application.system.userManagement.data.dto.Register;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterResponse {
    private Long id;
    private String message;
    private boolean isSuccess;
}

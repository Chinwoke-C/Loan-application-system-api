package com.loan.application.system.userManagement.data.dto.Request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MailInfo {
    private String name;
    private String email;
}

package com.loan.application.system.email;

public interface EmailService {
    void sendEmail(String to, String subject, String htmlContent);
}

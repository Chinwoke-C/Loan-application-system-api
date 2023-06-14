package com.loan.application.system.email.impl;

import com.loan.application.system.email.EmailService;
import com.loan.application.system.userManagement.data.dto.Request.EmailRequest;
import com.loan.application.system.userManagement.data.dto.Request.MailInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private WebClient.Builder webclient;

    @Value("${mail.api.key}")
    private String mailApiKey;

    @Value("${sendinblue.mail.url}")
    private String mailUrl;

    @Value("${sendinblue.mail.name}")
    private String senderName;

    @Value("${sendinblue.mail.email}")
    private String senderEmail;
    @Override
    public void sendEmail(String to, String subject, String htmlContent) {
        EmailRequest emailRequest = EmailRequest.builder()
                .sender(MailInfo.builder().email(senderEmail).name(senderName).build())
                .to(List.of(MailInfo.builder().email(to).name(to).build()))
                .htmlContent(htmlContent)
                .subject(subject)
                .build();

        webclient
                .baseUrl(mailUrl)
                .defaultHeader("api-key", mailApiKey)
                .build()
                .post()
                .bodyValue(emailRequest)
                .retrieve()
                .bodyToMono(String.class)
                .block();

    }
}

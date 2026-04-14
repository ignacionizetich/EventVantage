package com.ignacionizetich.eventvantage.service.impl;

import com.ignacionizetich.eventvantage.DTO.requests.EmailRequest;
import com.ignacionizetich.eventvantage.service.emailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class emailServiceImpl implements emailService {


    private final RestClient restClient;

    @Value("${resend.api.key}")
    private String apikey;

    @Value("${resend.from.email}")
    private String fromEmail;

    public emailServiceImpl(RestClient.Builder builder){
        this.restClient = builder.baseUrl("https://api.resend.com").build();
    }

    @Override
    public void sendEmail(String to, String subject, String content){
        EmailRequest request = new EmailRequest(
                fromEmail,
                new String[]{to},
                subject,
                content
        );

        restClient.post()
                .uri("/emails")
                .header("Authorization", "Bearer "+apikey)
                .contentType(MediaType.APPLICATION_JSON)
                .body(request)
                .retrieve()
                .toBodilessEntity();
    }
}

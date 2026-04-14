package com.ignacionizetich.eventvantage.DTO.requests;


public record EmailRequest(String fromEmail, String[] strings, String subject, String content){}

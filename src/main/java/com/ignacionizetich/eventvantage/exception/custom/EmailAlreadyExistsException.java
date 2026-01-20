package com.ignacionizetich.eventvantage.exception.custom;

public class EmailAlreadyExistsException extends eventVantageException {
    public EmailAlreadyExistsException(String email) {
        super("El email '" + email + "' ya se encuentra registrado en el sistema.");
    }
}
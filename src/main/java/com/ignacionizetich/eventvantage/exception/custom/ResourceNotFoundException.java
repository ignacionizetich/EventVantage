package com.ignacionizetich.eventvantage.exception.custom;

public class ResourceNotFoundException extends eventVantageException {
    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s no encontrado con %s: '%s'", resourceName, fieldName, fieldValue));
    }
}

package com.ignacionizetich.eventvantage.exception.custom;

public class DuplicateEventException extends eventVantageException {
    public DuplicateEventException(String event) {
        super(event);
    }
}

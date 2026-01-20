package com.ignacionizetich.eventvantage.exception.custom;

public class DniAlreadyExistsException extends eventVantageException {
  public DniAlreadyExistsException(String dni) {
    super("Ya existe un usuario registrado con el DNI: " + dni);
  }
}

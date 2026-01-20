package com.ignacionizetich.eventvantage.exception;

import com.ignacionizetich.eventvantage.exception.Error.errorResponse;
import com.ignacionizetich.eventvantage.exception.custom.EmailAlreadyExistsException;
import com.ignacionizetich.eventvantage.exception.custom.ResourceNotFoundException;
import com.ignacionizetich.eventvantage.exception.custom.DniAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 1. Errores de validación de campos (@Valid en el DTO)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    // 2. Errores de recursos duplicados (Email o DNI ya existen) - Devuelve 409 Conflict
    @ExceptionHandler({EmailAlreadyExistsException.class, DniAlreadyExistsException.class})
    public ResponseEntity<errorResponse> handleConflictExceptions(RuntimeException ex) {
        errorResponse error = new errorResponse(
                HttpStatus.CONFLICT.value(),
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

    // 3. Errores de búsqueda (No se encontró el ID, etc) - Devuelve 404 Not Found
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<errorResponse> handleResourceNotFound(ResourceNotFoundException ex) {
        errorResponse error = new errorResponse(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    // 4. Errores de lógica generales
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<errorResponse> handleRuntimeException(RuntimeException ex) {
        errorResponse error = new errorResponse(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    // 5. Error genérico del servidor (500)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<errorResponse> handleGlobalException(Exception ex) {
        errorResponse error = new errorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Ocurrió un error inesperado en el servidor",
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
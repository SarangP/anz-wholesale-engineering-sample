package com.anz.wholesale.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global exception handler
 */
@ControllerAdvice
public class AccountException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    @ExceptionHandler(value = AccountException.class)
    public ResponseEntity<Object> exception(AccountException exception) {
        return new ResponseEntity<>("Account not found", HttpStatus.NOT_FOUND);
    }
}

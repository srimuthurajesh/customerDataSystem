package com.relx.microservice.customer.controller;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.validation.FieldError;


@ControllerAdvice
public class CustomerExceptionHandler {

    
    @ExceptionHandler
    public ResponseEntity<ControllerErrorResponse> handleException(Exception exc) {
        String msg = "Something went wrong, try again later or contact our support team";

        ControllerErrorResponse error = new ControllerErrorResponse(HttpStatus.BAD_REQUEST.value(), msg,
                System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ControllerErrorResponse> handleConstaintViolatoinException(
            final ConstraintViolationException ex) {

        StringBuilder message = new StringBuilder();
        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
        for (ConstraintViolation<?> violation : violations) {
            message.append(violation.getPropertyPath());
            message.append(" : " + violation.getMessage().concat("; "));
        }

        ControllerErrorResponse error = new ControllerErrorResponse(HttpStatus.BAD_REQUEST.value(), message.toString(),
                System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ControllerErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        StringBuilder message = new StringBuilder();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            message.append(((FieldError) error).getField());
            message.append(" : " + error.getDefaultMessage() + "; ");
        });
        ControllerErrorResponse error = new ControllerErrorResponse(HttpStatus.BAD_REQUEST.value(), message.toString(),
                System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}

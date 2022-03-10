package com.tld.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeRestExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<EmployeErreurResponse> handleException(EmployeNotFoundException e) {
        EmployeErreurResponse error = new EmployeErreurResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(e.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    // ajouter un autre exception handler pour gérer les autres exceptions (catch
// all)
    @ExceptionHandler
    public ResponseEntity<EmployeErreurResponse> handleException(Exception e){
        EmployeErreurResponse error = new EmployeErreurResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(e.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}

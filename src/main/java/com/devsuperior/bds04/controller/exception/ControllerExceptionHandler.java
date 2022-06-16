package com.devsuperior.bds04.controller.exception;

import com.devsuperior.bds04.exceptions.DataBaseException;
import com.devsuperior.bds04.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<StandardError> databaseError(HttpServletRequest request, DataBaseException e){
        StandardError err = createStandardError(request, e);
        err.setStatus(HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.badRequest().body(err);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> emptyResult(HttpServletRequest request, ResourceNotFoundException e) {
        StandardError err = createStandardError(request, e);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<StandardError> usernameNotFound(HttpServletRequest request, ResourceNotFoundException e) {
        StandardError err = createStandardError(request, e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

    private StandardError createStandardError(HttpServletRequest request, RuntimeException e) {
        StandardError err = new StandardError();
        err.setMessage(e.getMessage());
        err.setError("Error");
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setTimestamp(Instant.now());
        err.setPath(request.getRequestURI());
        return err;
    }
}

package org.danielbreves.workshopmongo.resources.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.danielbreves.workshopmongo.service.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<StandartErrorException> objectNotFound(UserNotFoundException e, HttpServletRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;
        StandartErrorException error = new StandartErrorException(System.currentTimeMillis(), status.value(), "não encontrado", e.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(error, status);
    }
}

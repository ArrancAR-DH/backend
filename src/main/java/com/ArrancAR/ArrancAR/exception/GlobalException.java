package com.ArrancAR.ArrancAR.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<String> ResourceNotFoundException(ResourceNotFoundException rnfe){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(rnfe.getMessage());
    }

    @ExceptionHandler({DataIntegrityViolationException.class})
    public ResponseEntity<String> DataIntegrityViolationException(DataIntegrityViolationException dataIntegrityViolationException) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(dataIntegrityViolationException.getMessage());
    }
    @ExceptionHandler(AuthException.class)
    public ResponseEntity<ErrorDetails> handleTodoAPIException(AuthException exception,
                                                               WebRequest webRequest){

        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false)
        );

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({BusinessException.class})
    public ResponseEntity<String> BusinessException(BusinessException businessException) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(businessException.getMessage());
    }
}
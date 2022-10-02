package com.example.training.exception;

import com.example.training.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorAdviser
{
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResponse> handleBaseException(BaseException e){
    ErrorResponse response = new ErrorResponse();
    response.setError(e.getMessage());
    response.setStatus(HttpStatus.EXPECTATION_FAILED.value());
    return new ResponseEntity<>(response,HttpStatus.EXPECTATION_FAILED);
}
}

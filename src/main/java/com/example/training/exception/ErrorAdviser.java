package com.example.training.exception;

import com.example.training.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorAdviser
{
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorResponse> studentNotFound(StudentNotFoundException e){
        ErrorResponse response = new ErrorResponse();
        String message = "Not Found Student Id : " + e.getMessage();
        response.setError(message);
        response.setStatus(HttpStatus.EXPECTATION_FAILED.value());
        return new ResponseEntity<>(response,HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(DataNullException.class)
    public ResponseEntity<ErrorResponse> dataNull(DataNullException e){

        ErrorResponse message = new ErrorResponse();
        message.setError(e.getMessage() + " is null or empty.");
        message.setStatus(HttpStatus.BAD_REQUEST.value());

        return new  ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
    }
}

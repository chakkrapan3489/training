package com.example.training.exception;

import com.example.training.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorAdviser
{
//    @ExceptionHandler(StudentNotFoundException.class)
//    public ResponseEntity<ErrorResponse> studentNotFound(StudentNotFoundException e){
//        ErrorResponse response = new ErrorResponse();
//        String message = "Not Found Student Id : " + e.getMessage();
//        response.setError(message);
//        response.setStatus(HttpStatus.EXPECTATION_FAILED.value());
//        return new ResponseEntity<>(response,HttpStatus.EXPECTATION_FAILED);
//    }
//
//    @ExceptionHandler(DataNullException.class)
//    public ResponseEntity<ErrorResponse> dataNull(DataNullException e) {
//
//        ErrorResponse message = new ErrorResponse();
//        message.setError(e.getMessage() + " is null or empty.");
//        message.setStatus(HttpStatus.EXPECTATION_FAILED.value());
//
//        return new ResponseEntity<>(message, HttpStatus.EXPECTATION_FAILED);
//    }
//
//    @ExceptionHandler(GradeFormatException.class)
//    public ResponseEntity<ErrorResponse> gradeFormat(GradeFormatException e){
//        ErrorResponse message = new ErrorResponse();
//        message.setError(e.getMessage() + " format must be A - F.");
//        message.setStatus(HttpStatus.EXPECTATION_FAILED.value());
//
//        return new  ResponseEntity<>(message,HttpStatus.EXPECTATION_FAILED);
//    }
//
//    @ExceptionHandler(GenderFormatException.class)
//    public ResponseEntity<ErrorResponse> genderFormat(GenderFormatException e){
//        ErrorResponse message = new ErrorResponse();
//        message.setError(e.getMessage() + " format must be M or F.");
//        message.setStatus(HttpStatus.EXPECTATION_FAILED.value());
//
//        return new  ResponseEntity<>(message,HttpStatus.EXPECTATION_FAILED);
//    }
//
//    @ExceptionHandler(NameFormatException.class)
//    public ResponseEntity<ErrorResponse> nameFormat(NameFormatException e){
//        ErrorResponse message = new ErrorResponse();
//        message.setError(e.getMessage() + " format must be a-z or A-Z.");
//        message.setStatus(HttpStatus.EXPECTATION_FAILED.value());
//
//        return new  ResponseEntity<>(message,HttpStatus.EXPECTATION_FAILED);
//    }
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResponse> handleBaseException(BaseException e){
    ErrorResponse response = new ErrorResponse();
    response.setError(e.getMessage());
    response.setStatus(HttpStatus.EXPECTATION_FAILED.value());
    return new ResponseEntity<>(response,HttpStatus.EXPECTATION_FAILED);
}
}

package com.example.training.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(int id){
        super(String.valueOf(id));
    }

}

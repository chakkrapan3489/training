package com.example.training.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {

    private LocalDateTime timestamp = LocalDateTime.now();

    private int status;

    private String error;

}

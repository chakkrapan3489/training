package com.example.training.model;

import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
public class StudentRequest {

    private String name;

    private String gender;

    private String grade;


}

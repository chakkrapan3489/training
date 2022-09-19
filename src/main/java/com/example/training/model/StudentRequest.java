package com.example.training.model;

import lombok.Data;



@Data
public class StudentRequest {
    private String name;

    private char gender;

   // @Pattern(regexp="^[A-F]{2}",message="length must be 2")
    private String grade;


}

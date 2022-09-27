package com.example.training.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "student")
public class Student {

    @Transient
    public static final String SEQUENCE_NAME = "student_sequence";

    @Id
    private int id;

    private String name;

    private String gender;

    private String grade;


}

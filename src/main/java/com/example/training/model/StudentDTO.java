package com.example.training.model;

import lombok.Data;
import lombok.Generated;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "student")
public class StudentDTO {

    @Id
    private int id;

    private String name;

    private String gender;

    private String grade;


}

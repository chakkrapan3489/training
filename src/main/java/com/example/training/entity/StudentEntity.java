package com.example.training.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "student")
public class StudentEntity extends BaseEntity {

    @Column(nullable = false,length = 50)
    private String name;

    @Column(nullable = false)
    private char gender;

    @Column(nullable = false,length = 5)
    private String grade;

}

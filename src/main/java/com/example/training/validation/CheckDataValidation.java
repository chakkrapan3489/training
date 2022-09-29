package com.example.training.validation;

import com.example.training.exception.DataNullException;
import com.example.training.model.StudentRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class CheckDataValidation {

    public void CheckDataValidation(StudentRequestDTO request) {
        if (request.getName() == null || request.getName().isEmpty()) {
            throw new DataNullException("name");
        }
        if (request.getGrade() == null || request.getName().isEmpty()) {
            throw new DataNullException("grade");
        }
        if (request.getGender() == null || request.getGender().isEmpty()) {
            throw new DataNullException("gender");
        }
    }
}

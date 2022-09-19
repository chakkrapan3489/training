package com.example.training.validation;

import com.example.training.exception.DataNullException;
import com.example.training.model.StudentRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CheckDataValidation {

    public void CheckDataValidation(StudentRequest request) {
        if (request.getName() == null || request.getName().isEmpty()) {
            throw new DataNullException("name");
        }
        if (request.getGrade() == null || request.getName().isEmpty()) {
            throw new DataNullException("grade");
        }
        if (request.getGender() == 0) {
            throw new DataNullException("gender");
        }
    }
}

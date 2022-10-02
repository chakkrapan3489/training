package com.example.training.validation;

import com.example.training.exception.BaseException;
import com.example.training.exception.StudentException;
import com.example.training.model.StudentRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class CheckDataValidation {

    public void CheckDataValidation(StudentRequestDTO request) throws BaseException {
        if (request.getName() == null || request.getName().isEmpty()) {
            throw StudentException.DataNullException("name");
        }
        if (request.getGrade() == null || request.getName().isEmpty()) {
            throw StudentException.DataNullException("grade");
        }
        if (request.getGender() == null || request.getGender().isEmpty()) {
            throw StudentException.DataNullException("gender");
        }
    }
}

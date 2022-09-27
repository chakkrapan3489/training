package com.example.training.mapper;

import com.example.training.model.StudentDTO;
import com.example.training.model.StudentRequest;
import com.example.training.model.StudentResponse;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDTO toStudentDTO(StudentRequest request);

    StudentResponse toStudentResponse(Optional<StudentDTO> student);
}
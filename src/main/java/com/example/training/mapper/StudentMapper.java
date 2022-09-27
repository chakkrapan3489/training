package com.example.training.mapper;

import com.example.training.model.Student;
import com.example.training.model.StudentRequest;
import com.example.training.model.StudentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    Student toStudent(StudentRequest request);

    StudentResponse toStudentResponse(Student student);
}
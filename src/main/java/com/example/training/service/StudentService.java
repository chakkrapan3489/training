package com.example.training.service;

import com.example.training.model.StudentRequest;
import com.example.training.model.StudentDTO;
import com.example.training.repository.StudentRepository;
import com.example.training.validation.CheckDataValidation;
import com.example.training.validation.Regex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CheckDataValidation checkData;

    @Autowired
    private Regex regex;

    public List<StudentDTO> getStudents() {
        List<StudentDTO> students = new ArrayList<>();
        return students;
    }

    public StudentDTO getStudentById(int id) {

        StudentDTO resposne = new StudentDTO();
        return resposne;
    }

    public StudentDTO createStudent(StudentRequest request) {

        checkData.CheckDataValidation(request);
        regex.checkFormat(request);
        studentRepository.insert(request);
        return data;
    }

//    public StudentEntity updateStudentById(int id,StudentRequest request) {
//
//
//
//        return new StudentEntity();
//    }
//
//    public String deleteStudentById(int id) {
//
//        return "Student Id : " + id + " have been Delete";
//    }
}

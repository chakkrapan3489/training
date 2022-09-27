package com.example.training.service;

import com.example.training.exception.StudentNotFoundException;
import com.example.training.mapper.StudentMapper;
import com.example.training.model.StudentDTO;
import com.example.training.model.StudentRequest;
import com.example.training.model.StudentResponse;
import com.example.training.repository.StudentRepository;
import com.example.training.validation.CheckDataValidation;
import com.example.training.validation.Regex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CheckDataValidation checkData;

    @Autowired
    private Regex regex;

    @Autowired
    private StudentMapper studentMapper;

    public List<StudentDTO> getStudents() {
        List<StudentDTO> students = studentRepository.findAll();
        return students;
    }

    public StudentResponse getStudentById(int id) {
        Optional<StudentDTO> student = studentRepository.findById(id);
        if (student.isEmpty()) {
            throw new StudentNotFoundException(id);
        }
        return studentMapper.toStudentResponse(student);
    }

    public StudentDTO createStudent(StudentRequest request) {

        checkData.CheckDataValidation(request);
        regex.checkFormat(request);
        StudentDTO data = studentMapper.toStudentDTO(request);
        return studentRepository.save(data);
    }

    public StudentResponse updateStudentById(int id,StudentRequest request) {
        Optional<StudentDTO> student = studentRepository.findById(id);
        if (student.isEmpty()){
            throw new StudentNotFoundException(id);
        }

        return studentMapper.toStudentResponse(student);
    }

    public String deleteStudentById(int id) {

        return "Student Id : " + id + " have been Delete";
    }
}

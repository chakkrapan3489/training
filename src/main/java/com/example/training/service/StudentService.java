package com.example.training.service;

import com.example.training.exception.StudentNotFoundException;
import com.example.training.mapper.StudentMapper;
import com.example.training.model.Student;
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


    public List<Student> getStudents() {
        List<Student> students = studentRepository.findAll();
        return students;
    }

    public StudentResponse getStudentById(int id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()) {
            throw new StudentNotFoundException(id);
        }

        return StudentMapper.INSTANCE.toStudentResponse(student.get());
    }

    public Student createStudent(StudentRequest request) {

        checkData.CheckDataValidation(request);
        regex.checkFormat(request);
        Student data = StudentMapper.INSTANCE.toStudent(request);
        data.setId(SequenceGeneratorService.generateSequence(data.SEQUENCE_NAME));
        return studentRepository.save(data);
    }

    public StudentResponse updateStudentById(int id, StudentRequest request) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()) {
            throw new StudentNotFoundException(id);
        }
         StudentMapper.INSTANCE.toStudent(request);

        return StudentMapper.INSTANCE.toStudentResponse(student.get());
    }

    public String deleteStudentById(int id) {

        return "Student Id : " + id + " have been Delete";
    }
}

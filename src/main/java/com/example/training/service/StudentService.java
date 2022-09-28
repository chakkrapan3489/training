package com.example.training.service;

import com.example.training.business.StudentBusiness;
import com.example.training.exception.StudentNotFoundException;
import com.example.training.mapper.StudentMapper;
import com.example.training.model.Student;
import com.example.training.model.StudentRequest;
import com.example.training.model.StudentResponse;
import com.example.training.repository.StudentRepository;
import com.example.training.validation.CheckDataValidation;
import com.example.training.validation.Regex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
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
    private StudentBusiness studentBusiness;


    public List<Student> getStudents(String name, String grade, String gender) {
        List<Student> students = studentBusiness.getStudentsByParam(name, grade, gender);
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

    public Student updateStudentById(int id, StudentRequest request) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()) {
            throw new StudentNotFoundException(id);
        }
        request.setId(id);
        return studentRepository.save(StudentMapper.INSTANCE.toStudent(request));
    }

    public String deleteStudentById(int id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()) {
            throw new StudentNotFoundException(id);
        }
        studentRepository.deleteById(id);
        return "Student Id : " + id + " have been Delete";
    }
}

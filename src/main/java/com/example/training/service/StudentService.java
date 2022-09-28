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
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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
    private MongoTemplate mongoTemplate;


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

    public List<Student> getStudentsByParam;

    public Student createStudent(StudentRequest request) {
        checkData.CheckDataValidation(request);
        regex.checkFormat(request);
        Student data = StudentMapper.INSTANCE.toStudent(request);
        data.setId(SequenceGeneratorService.generateSequence(data.SEQUENCE_NAME));
        return studentRepository.save(data);
    }

    public Student updateStudentById(int id, StudentRequest request) {
        Student student = mongoTemplate.findOne(Query.query(Criteria.where("id").is(id)), Student.class);
        if (student == null) {
            throw new StudentNotFoundException(id);
        }
        request.setId(id);
        return mongoTemplate.save(StudentMapper.INSTANCE.toStudent(request));
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

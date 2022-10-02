package com.example.training.service;

import com.example.training.business.StudentBusiness;
import com.example.training.exception.BaseException;
import com.example.training.exception.StudentException;
import com.example.training.mapper.StudentMapper;
import com.example.training.model.Student;
import com.example.training.model.StudentRequestDTO;
import com.example.training.model.StudentResponseDTO;
import com.example.training.repository.StudentRepository;
import com.example.training.validation.CheckDataValidation;
import com.example.training.validation.Regex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
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


    public List<Student> getStudents(Map<String,String> request) {
        List<Student> students = studentBusiness.getStudentsByParam(request);
        return students;
    }

    public StudentResponseDTO getStudentById(int id) throws BaseException{
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()) {
            throw StudentException.StudentNotFound(id);
        }
        return StudentMapper.INSTANCE.toStudentResponse(student.get());
    }

    public Student createStudent(StudentRequestDTO request) throws BaseException {
        checkData.CheckDataValidation(request);
        regex.checkFormat(request);
        Student data = StudentMapper.INSTANCE.toStudent(request);
        data.setId(SequenceGeneratorService.generateSequence(data.SEQUENCE_NAME));
        return studentRepository.save(data);
    }

    public Student updateStudentById(int id, StudentRequestDTO request) throws BaseException {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()) {
            throw StudentException.StudentNotFound(id);
        }
        Student studentGetData  = student.get();
        request.setId(student.get().getId());
        studentGetData = StudentMapper.INSTANCE.toStudent(request);
        return studentRepository.save(studentGetData);
    }

    public String deleteStudentById(int id) throws BaseException{
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()) {
            throw StudentException.StudentNotFound(id);
        }
        studentRepository.deleteById(id);
        return "Student Id : " + id + " have been Delete";
    }
}

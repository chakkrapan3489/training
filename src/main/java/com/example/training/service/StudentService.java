package com.example.training.service;

import com.example.training.entity.StudentEntity;
import com.example.training.exception.StudentNotFoundException;
import com.example.training.model.StudentRequest;
import com.example.training.model.Student;
import com.example.training.repository.StudentRepository;
import com.example.training.validation.CheckDataValidation;
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

    public List<StudentEntity> getStudents() {
        List<StudentEntity> students = studentRepository.findAll();
        return students;
    }

    public Student getStudentById(int id) {
        Optional<StudentEntity> student = studentRepository.findById(id);
        if (student.isEmpty()) {
            throw new StudentNotFoundException(id);
        }
        Student resposne = new Student();
        resposne.setId(student.get().getId());
        resposne.setName(student.get().getName());
        resposne.setGender(student.get().getGender());
        resposne.setGrade(student.get().getGrade());
        return resposne;
    }

    public StudentEntity createStudent(StudentRequest request) {

        checkData.CheckDataValidation(request);
        StudentEntity data = new StudentEntity();
        data.setName(request.getName());
        data.setGender(request.getGender());
        data.setGrade(request.getGrade());
        return studentRepository.save(data);
    }

    public StudentEntity updateStudentById(int id,StudentRequest request) {
        StudentEntity student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));

        student.setName(request.getName());
        student.setGrade(request.getGrade());
        student.setGender(request.getGender());

        return studentRepository.save(student);
    }

    public String deleteStudentById(int id) {
        Optional<StudentEntity> student = studentRepository.findById(id);
        if (student.isEmpty()) {
            throw new StudentNotFoundException(id);
        }
        studentRepository.deleteById(id);
        return "Student Id : " + id + " have been Delete";
    }
}

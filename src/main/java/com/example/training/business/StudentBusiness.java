package com.example.training.business;

import com.example.training.model.Student;
import com.example.training.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class StudentBusiness {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudentsByParam(String name, String grade, String gender) {
        List<Student> students = new ArrayList<>();
        if (name != null && grade != null && gender != null) {
            students = studentRepository.findAllByNameAndGradeAndGender(name, grade, gender);
        } else if (name != null && grade != null) {
            students = studentRepository.findAllByNameAndGrade(name, grade);
        } else if (name != null && gender != null) {
            students = studentRepository.findAllByNameAndGender(name, gender);
        } else if (name != null && grade == null && gender == null) {
            students = studentRepository.findAllByName(name);
        } else if (name == null && grade != null && gender != null) {
            students = studentRepository.findAllByGenderAndGrade(gender, grade);
        } else if (name == null && grade != null && gender == null) {
            students = studentRepository.findAllByGrade(grade);
        } else if (name == null && grade == null && gender != null) {
            students = studentRepository.findAllByGender(gender);
        } else {
            students = studentRepository.findAll();
        }
        return students;
    }
}

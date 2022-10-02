package com.example.training.controller;

import com.example.training.exception.BaseException;
import com.example.training.model.Student;
import com.example.training.model.StudentRequestDTO;
import com.example.training.model.StudentResponseDTO;
import com.example.training.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService  studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(@RequestParam Map<String,String> request) throws BaseException {
        return  ResponseEntity.ok(studentService.getStudents(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> getStudentById(@PathVariable int id) throws BaseException {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping
    public ResponseEntity<Student> saveStudents(@RequestBody StudentRequestDTO request) throws BaseException {
        return ResponseEntity.ok(studentService.createStudent(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudentById(@PathVariable int id,@RequestBody StudentRequestDTO request) throws BaseException{
        return ResponseEntity.ok(studentService.updateStudentById(id,request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable int id) throws BaseException {
        return ResponseEntity.ok(studentService.deleteStudentById(id));
    }

}


package com.example.training.controller;

import com.example.training.model.StudentDTO;
import com.example.training.model.StudentRequest;
import com.example.training.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService  studentService;

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        return ResponseEntity.ok(studentService.getStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable int id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping
    public ResponseEntity<StudentDTO> saveStudents(@RequestBody StudentRequest request) {
        return ResponseEntity.ok(studentService.createStudent(request));
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<StudentEntity> updateStudentById(@PathVariable int id,@RequestBody StudentRequest request) {
//        return ResponseEntity.ok(studentService.updateStudentById(id,request));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteStudentById(@PathVariable int id) {
//        return ResponseEntity.ok(studentService.deleteStudentById(id));
//    }

}


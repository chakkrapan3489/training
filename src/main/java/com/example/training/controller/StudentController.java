package com.example.training.controller;

import com.example.training.model.Student;
import com.example.training.model.StudentRequestDTO;
import com.example.training.model.StudentResponseDTO;
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
    public ResponseEntity<List<Student>> getAllStudents(@RequestParam(required = false) String name,@RequestParam(required = false) String grade,@RequestParam(required = false) String gender) {
        return ResponseEntity.ok(studentService.getStudents(name,grade,gender));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> getStudentById(@PathVariable int id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping
    public ResponseEntity<Student> saveStudents(@RequestBody StudentRequestDTO request) {
        return ResponseEntity.ok(studentService.createStudent(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudentById(@PathVariable int id,@RequestBody StudentRequestDTO request) {
        return ResponseEntity.ok(studentService.updateStudentById(id,request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable int id) {
        return ResponseEntity.ok(studentService.deleteStudentById(id));
    }

}


package com.example.training.repository;

import com.example.training.model.StudentDTO;
import com.example.training.model.StudentRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<StudentDTO,Integer> {
    void insert(StudentRequest request);
}

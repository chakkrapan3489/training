package com.example.training.repository;
import com.example.training.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface StudentRepository extends MongoRepository<Student,Integer> {
}

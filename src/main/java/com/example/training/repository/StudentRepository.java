package com.example.training.repository;

import com.example.training.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface StudentRepository extends MongoRepository<Student,Integer> {
   //List<Student> findAllByNameGenderGrade( String name,String gender,String grade);

}
package com.example.training.repository;
import com.example.training.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.SimpleTimeZone;

public interface StudentRepository extends MongoRepository<Student,Integer> {
    List<Student> findAllByGender(String gender);

    List<Student> findAllByName(String name);

    List<Student> findAllByGrade(String grade);

    List<Student> findAllByNameAndGender(String name,String gender);

    List<Student> findAllByNameAndGrade(String name,String grade);

    List<Student> findAllByGenderAndGrade(String gender,String grade);

    List<Student> findAllByNameAndGradeAndGender(String name,String grade,String gender);
}

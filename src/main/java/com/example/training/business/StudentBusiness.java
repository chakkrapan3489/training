package com.example.training.business;

import com.example.training.model.Student;
import com.example.training.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class StudentBusiness {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Student> getStudentsByParam(Map<String, String> request) {
        String gender = request.get("gender");
        String name = request.get("name");
        String grade = request.get("grade");
        Query query = new Query();
        List<Criteria> criteria = new ArrayList<>();
        if (name != null) {
            criteria.add(Criteria.where("name").is(name));
        }
        if (gender != null) {
            criteria.add(Criteria.where("gender").is(gender));
        }
        if (grade != null) {
            criteria.add(Criteria.where("grade").is(grade));
        }
        if (!criteria.isEmpty()) {
            query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[0])));
        }
        return mongoTemplate.find(query, Student.class);
    }
}

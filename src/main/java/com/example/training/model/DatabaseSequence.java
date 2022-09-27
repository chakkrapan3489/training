package com.example.training.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Document(collection = "database_sequences")
@Component
@Data
public class DatabaseSequence {

    @Id
    private String id;
    private int seq;

}

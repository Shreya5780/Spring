package com.mongo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("quizSubject")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SubjectModel {
    @Id
    private String id;
    private String subjectName;
}

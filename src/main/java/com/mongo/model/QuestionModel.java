package com.mongo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("questions")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class QuestionModel {
    @Id
    private String qid;

    private String subjectId;
    private String question;
    private String answer;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
}

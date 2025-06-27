package com.mongo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("scores")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ScoreModel {
    @Id
    private String scoreId;
    private String userId;
    private String subjectId;
    private int score;
}

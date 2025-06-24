package com.repository;

import com.mongo.model.QuestionModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QuestionRepo extends MongoRepository<QuestionModel, String> {

    List<QuestionModel> findQuestionBySubjectId(String subjectId);
}

package com.repository;

import com.mongo.model.ScoreModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ScoreRepo extends MongoRepository<ScoreModel,String> {


    ScoreModel save(ScoreModel scoreModel);

    List<ScoreModel> findByUserId(String userId);

    List<ScoreModel> findBySubjectId(String subjectId);
}

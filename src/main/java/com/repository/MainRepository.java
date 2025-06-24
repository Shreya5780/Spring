package com.repository;

import com.mongo.model.QuizSubject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainRepository extends MongoRepository<QuizSubject, String> {

    QuizSubject findBySubjectName(String subjectName);


}
//("{name:'?0'}")

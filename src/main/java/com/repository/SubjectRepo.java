package com.repository;

import com.mongo.model.SubjectModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepo extends MongoRepository<SubjectModel, String> {

    SubjectModel findBySubjectName(String subjectName);


}
//("{name:'?0'}")

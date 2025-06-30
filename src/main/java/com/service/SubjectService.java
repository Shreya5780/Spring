package com.service;

import com.mongo.model.QuestionModel;
import com.mongo.model.SubjectModel;
import com.repository.QuestionRepo;
import com.repository.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class SubjectService {
    @Autowired
    SubjectRepo subjectRepo;

    @Autowired
    QuestionRepo questionRepo;

    public ResponseEntity<String> addSubject( String subject){

        SubjectModel subjectModel =new SubjectModel();
        subjectModel.setId(null);
        subjectModel.setSubjectName(subject.toUpperCase());
//        System.out.println(quizSubject.getSubjectName());
        subjectRepo.save(subjectModel);

        return ResponseEntity.status(HttpStatus.CREATED).body("Success, " + subject + " added successfully");

//        return "Subject " +  subject + " added successfully";
    }

    public SubjectModel getSubject( String subject){
        SubjectModel subjectModel =   subjectRepo.findBySubjectName(subject.toUpperCase());
        if(subjectModel == null){
           throw new IllegalArgumentException("Subject not found")  ;
//            return "Subject " +  subject + " not found";
        }
        return subjectModel;

    }

    public List<SubjectModel> getAllSubjects(){
        return subjectRepo.findAll();
    }

    public ResponseEntity<String> updateSubject( String subjectId, String subjectName){
        SubjectModel subjectModel = subjectRepo.findById(subjectId).orElse(null);
        if(subjectModel == null){
            throw new IllegalArgumentException("Subject not found")  ;
        }
        subjectModel.setSubjectName(subjectName.toUpperCase());
        subjectRepo.save(subjectModel);
        return ResponseEntity.status(HttpStatus.RESET_CONTENT).body("Success, " + subjectName + " updated successfully");
    }

    public ResponseEntity<String> deleteSubject( String subjectId) {
        SubjectModel subjectModel = subjectRepo.findById(subjectId).orElse(null);
        if (subjectModel == null) {
            throw new IllegalArgumentException("Subject not found")  ;
        }
        subjectRepo.delete(subjectModel);

        List<QuestionModel> questions = questionRepo.findQuestionBySubjectId(subjectId);

        for (QuestionModel question : questions) {
            questionRepo.delete(question);
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Successfully deleted successfully");
    }
}

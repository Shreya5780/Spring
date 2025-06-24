package com.service;

import com.mongo.model.SubjectModel;
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

    public ResponseEntity<String> addSubject(@PathVariable String subject){

        SubjectModel subjectModel =new SubjectModel();
        subjectModel.setId(null);
        subjectModel.setSubjectName(subject.toUpperCase());
//        System.out.println(quizSubject.getSubjectName());
        subjectRepo.save(subjectModel);

        return ResponseEntity.status(HttpStatus.CREATED).body("Success, " + subject + " added successfully");

//        return "Subject " +  subject + " added successfully";
    }

    public SubjectModel getSubject(@PathVariable String subject){
        SubjectModel subjectModel =   subjectRepo.findBySubjectName(subject.toUpperCase());
        if(subjectModel == null){
            return subjectModel;
//            return "Subject " +  subject + " not found";
        }
        return subjectModel;
//        return ResponseEntity.ok("Subject found " + quizSubject.getSubjectName() + " with id " + quizSubject.getId());
//        return "Subject found " +  quizSubject.getSubjectName() + " with id " + quizSubject.getId();

    }

    public List<SubjectModel> getAllSubjects(){
        return subjectRepo.findAll();
    }

    public ResponseEntity<String> updateSubject(@PathVariable String subjectId,@RequestParam String subjectName){
        SubjectModel subjectModel = subjectRepo.findById(subjectId).orElse(null);
        if(subjectModel == null){
            return ResponseEntity.notFound().build();
        }
        subjectModel.setSubjectName(subjectName.toUpperCase());
        subjectRepo.save(subjectModel);
        return ResponseEntity.status(HttpStatus.RESET_CONTENT).body("Success, " + subjectName + " updated successfully");
    }

    public ResponseEntity<String> deleteSubject(@PathVariable String subjectId) {
        SubjectModel subjectModel = subjectRepo.findById(subjectId).orElse(null);
        if (subjectModel == null) {
            return ResponseEntity.notFound().build();
        }
        subjectRepo.delete(subjectModel);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Successfully deleted successfully");
    }
}

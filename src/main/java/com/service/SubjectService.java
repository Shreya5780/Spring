package com.service;

import com.mongo.model.QuizSubject;
import com.repository.MainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class SubjectService {
    @Autowired
    MainRepository mainRepository;

    public ResponseEntity<String> addSubject(@PathVariable String subject){

        QuizSubject quizSubject =new QuizSubject();
        quizSubject.setId(null);
        quizSubject.setSubjectName(subject.toUpperCase());
//        System.out.println(quizSubject.getSubjectName());
        mainRepository.save(quizSubject);

        return ResponseEntity.status(HttpStatus.CREATED).body("Success, " + subject + " added successfully");

//        return "Subject " +  subject + " added successfully";
    }

    public QuizSubject getSubject(@PathVariable String subject){
        QuizSubject quizSubject =   mainRepository.findBySubjectName(subject.toUpperCase());
        if(quizSubject == null){
            return quizSubject;
//            return "Subject " +  subject + " not found";
        }
        return quizSubject;
//        return ResponseEntity.ok("Subject found " + quizSubject.getSubjectName() + " with id " + quizSubject.getId());
//        return "Subject found " +  quizSubject.getSubjectName() + " with id " + quizSubject.getId();

    }

    public List<QuizSubject> getAllSubjects(){
        return mainRepository.findAll();
    }

    public ResponseEntity<String> updateSubject(@PathVariable String subjectId,@RequestParam String subjectName){
        QuizSubject quizSubject = mainRepository.findById(subjectId).orElse(null);
        if(quizSubject == null){
            return ResponseEntity.notFound().build();
        }
        quizSubject.setSubjectName(subjectName.toUpperCase());
        mainRepository.save(quizSubject);
        return ResponseEntity.status(HttpStatus.RESET_CONTENT).body("Success, " + subjectName + " updated successfully");
    }

    public ResponseEntity<String> deleteSubject(@PathVariable String subjectId) {
        QuizSubject quizSubject = mainRepository.findById(subjectId).orElse(null);
        if (quizSubject == null) {
            return ResponseEntity.notFound().build();
        }
        mainRepository.delete(quizSubject);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Successfully deleted successfully");
    }
}

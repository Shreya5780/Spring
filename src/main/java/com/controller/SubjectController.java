package com.controller;

import com.mongo.model.QuizSubject;
import com.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class SubjectController {

    @Autowired
    SubjectService subjectService;


    @PostMapping("/add/{subject}")
    public ResponseEntity<String> add(@PathVariable String subject){

        return subjectService.addSubject(subject);
    }

    @GetMapping("/get/{subject}")
    public QuizSubject get(@PathVariable String subject){

         return subjectService.getSubject(subject);

    }

    @GetMapping("/getall")
    public List<QuizSubject> getAll(){
        return subjectService.getAllSubjects();
    }


    @PutMapping("/update/{subjectId}")
    public ResponseEntity<String> update(@PathVariable String subjectId, @RequestParam String subjectName){

        return subjectService.updateSubject(subjectId,subjectName);
    }

    @DeleteMapping("/delete/{subjectId}")
    public ResponseEntity<String> delete(@PathVariable String subjectId) {

        return subjectService.deleteSubject(subjectId);
    }
}

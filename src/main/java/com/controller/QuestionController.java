package com.controller;

import com.mongo.model.QuestionModel;
import com.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("/getall/{subjectName}")
    public List<QuestionModel> getAllQuestions(@PathVariable String subjectName){
        return questionService.getQuestionsBySubject(subjectName);
    }

    @PostMapping("/add/{subjectId}")
    public QuestionModel addQuestion(@RequestBody QuestionModel question, @PathVariable String subjectId){
        return questionService.addQuestionsBySubject(subjectId,question);
    }

    @PutMapping("/update/{questionId}")
    public QuestionModel updateQuestion(@RequestBody QuestionModel question, @PathVariable String questionId){
        return questionService.updateQuestionsBySubject(questionId,question);
    }

    @DeleteMapping("/delete/{questionId}")
    public ResponseEntity<String> deleteQuestion(@PathVariable String questionId){
        return questionService.deleteSubject(questionId);
    }

}

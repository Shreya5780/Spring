package org.example.quizeapp.controller;

import org.example.quizeapp.Question;
import org.example.quizeapp.YourData;
import org.example.quizeapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping("/quiz")
public class StartQuiz {

//    private String subject;
    private int score;

    @Autowired
    private QuizService quizService;


    @PostMapping("/{subject}")
    public List<Question> getSubjectQuestions(@PathVariable String subject){
        System.out.println("Start Quiz Post request");
        if(subject.equalsIgnoreCase("General") || subject.equalsIgnoreCase("AI") ||
                subject.equalsIgnoreCase("DSA") || subject.equalsIgnoreCase("ML")){
            System.out.println("Your preference is set to " + subject);
            return quizService.getQuiz(subject);

//            return "You quiz is going to start "  + " in subject " + subject;
        }else{
            return new ArrayList<>();
        }
    }

}

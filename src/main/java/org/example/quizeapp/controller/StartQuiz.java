package org.example.quizeapp.controller;

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

    @GetMapping("/start")
    public List<YourData> StartQuiz(@RequestParam String subject){
        System.out.println("Start Quiz ");
        System.out.println("Please select  your preference to from (Type General, ML, AI, DSA ");
//        Scanner sc = new Scanner(System.in);
//        subject = sc.nextLine();

        if(subject.equalsIgnoreCase("General") || subject.equalsIgnoreCase("AI") ||
                subject.equalsIgnoreCase("DSA") || subject.equalsIgnoreCase("ML")){
            System.out.println("Your preference is set to " + subject);
            quizService.Quiz(subject);
            return quizService.QuizStarted();

//            return "Success You Score " + score;
        }

        else{
            return null;
//            System.out.println("Wrong preference");
//            return "Wrong preference";
        }


    }

    @PostMapping("/{subject}")
    public String getSubjectQuestions(@PathVariable String subject){
        System.out.println("Start Quiz Post request");
        if(subject.equalsIgnoreCase("General") || subject.equalsIgnoreCase("AI") ||
                subject.equalsIgnoreCase("DSA") || subject.equalsIgnoreCase("ML")){
            System.out.println("Your preference is set to " + subject);
            quizService.Quiz(subject);
//            return quizService.QuizStarted();

            return "Success You Score " + score + " in subject " + subject;
        }else{
            return "new ArrayList<>()";
        }
    }



}

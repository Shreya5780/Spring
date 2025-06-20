package org.example.quizeapp;

import org.example.quizeapp.controller.DisplayQuestions;
import org.example.quizeapp.controller.StartQuiz;
import org.example.quizeapp.service.QuizService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuizeAppApplication {

    public static void main(String[] args) {

        SpringApplication.run(QuizeAppApplication.class, args);



//        StartQuiz startQuiz = new StartQuiz();

    }

}

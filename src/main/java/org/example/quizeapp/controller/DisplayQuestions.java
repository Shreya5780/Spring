package org.example.quizeapp.controller;

import org.example.quizeapp.Answer;
import org.example.quizeapp.Question;
import org.example.quizeapp.YourData;
import org.example.quizeapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/question")
public class DisplayQuestions {
    @Autowired
    private QuizService quizService;

    private List<Question> questionList;

    @GetMapping("/{subject}")
    public List<YourData> displayQuestion(@PathVariable String subject, @RequestParam List<String> answer){
        questionList = quizService.getQuiz(subject);
        return quizService.getYourDataList(questionList, answer);


    }
}

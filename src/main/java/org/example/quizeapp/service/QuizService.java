package org.example.quizeapp.service;

import org.example.quizeapp.Question;
import org.example.quizeapp.YourData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service

//here the service is component behind the scene
public class QuizService {

    List<Question> questionList;

    List<YourData> yourDataList = new ArrayList<>();

   @Autowired
   QuesionService quesionService;

    public void Quiz(String subject) {
        if(subject.equalsIgnoreCase("General")){
            questionList = quesionService.getGenQuestions();
        }else if(subject.equalsIgnoreCase("ML")){
            questionList = quesionService.getMLQuestionsList();
        }else if(subject.equalsIgnoreCase("AI")){
            questionList = quesionService.getAiQuestions();
        }else if(subject.equalsIgnoreCase("DSA")){
            questionList = quesionService.getDsaQuestions();
        }else {
            questionList = new ArrayList<>();
        }


    }

    public List<YourData> QuizStarted(){
        System.out.println("Quiz Started");
        int score=0;
        yourDataList.clear();
        for(Question question : questionList){
//            System.out.println(question);
            System.out.println(question.getQuestion());
            System.out.println("Choose correct ans A/B/C/D");
            System.out.println(question.getOption1());
            System.out.println(question.getOption2());
            System.out.println(question.getOption3());
            System.out.println(question.getOption4());

            Scanner sc = new Scanner(System.in);
            String choose = sc.nextLine().toLowerCase();
//            right now using console so i take input and use it because i don't able to find how the post request actually works

           if(choose.equals(question.getAnswer().toLowerCase())){
               score++;

           }else {
               System.out.println("Wrong answer.");
           }


        }

        String scorestr = "You Score " + score + " / " + questionList.size();
        YourData yourData = new YourData(questionList,  scorestr);
        yourDataList.add(yourData);
        return yourDataList;
    }


}

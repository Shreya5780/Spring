package org.example.quizeapp.service;

import org.example.quizeapp.Question;
import org.example.quizeapp.YourData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

//here the service is component behind the scene
public class QuizService {



    @Autowired
    QuesionServic quesionServic;
    public List<Question> getQuiz(String subject) {
        List<Question> questionList;
        System.out.println("Subject: " + subject);
        if(subject.equalsIgnoreCase("General")){
            questionList = quesionServic.getGenQuestions();
        }else if(subject.equalsIgnoreCase("ML")){
            questionList = quesionServic.getMLQuestionsList();
        }else if(subject.equalsIgnoreCase("AI")){
            questionList = quesionServic.getAiQuestions();
        }else if(subject.equalsIgnoreCase("DSA")){
            questionList = quesionServic.getDsaQuestions();
        }else {
            questionList = new ArrayList<>();
        }

        return questionList;
    }


    public List<YourData> getYourDataList(List<Question> questions, List<String> answer) {
        List<YourData> yourDataList = new ArrayList<>();
         int score=0;
        System.out.println("Score: " + score);
        for(int i=0; i<answer.size();i++) {
            System.out.println("Question: " + questions.get(i));
            System.out.println("Your Answer: " + answer.get(i));
            System.out.println("Correct Answer: " + questions.get(i).getAnswer());
            if((questions.get(i).getAnswer()).equalsIgnoreCase(answer.get(i))){
                score++;
//                System.out.println("Score: " + score);
            }

        }
        String scorestr = "You Score " + score + " / " + questions.size();
//        String choose="A";
        YourData yourData = new YourData(questions, answer, scorestr);
        yourDataList.add(yourData);

        return yourDataList;
    }




}

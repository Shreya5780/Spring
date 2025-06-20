package org.example.quizeapp;

import java.util.ArrayList;
import java.util.List;

public class YourData {

    List<Question> questions;
//    private String choose;
    private String score;

    public YourData(List<Question> question,  String score){
        this.score = score;
        this.questions = question;

    }

    public List<Question> getQuestions(){
        return questions;
    }



    public String getScore(){
        return score;
    }
}

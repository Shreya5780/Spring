package org.example.quizeapp;

import java.util.ArrayList;
import java.util.List;

public class YourData {

    List<Question> questions;

    List<String> answers;

    private String score;

    public YourData(List<Question> question,  List<String> answers, String score) {
       this.questions = question;
       this.answers = answers;
       this.score = score;

    }


    public List<Question> getQuestions() {
        return questions;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public String getScore() {
        return score;
    }
}

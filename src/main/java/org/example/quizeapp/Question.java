package org.example.quizeapp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

//data represent the data in  model type
//also we have repo pkg when works with repository
@Data

@AllArgsConstructor
//this will constructor autometically
//we need not to create any constructor with default, 1 , 2 .... params


public class Question {


    private String question;
    private String answer;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

//    public Question(String s, String ans, String o1, String o2, String o3, String o4) {
//        this.question = s;
//        this.answer = ans;
//        this.option1 = o1;
//        this.option2 = o2;
//        this.option3 = o3;
//        this.option4 = o4;
//    }

    public String getQuestion() {
        return question;
    }
    public String getAnswer() {
        return answer;
    }
    public String getOption1() { return option1; }
    public String getOption2() { return option2; }
    public String getOption3() { return option3; }
    public String getOption4() { return option4; }
}

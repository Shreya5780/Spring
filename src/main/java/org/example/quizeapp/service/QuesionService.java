package org.example.quizeapp.service;

import org.example.quizeapp.Question;
import org.example.quizeapp.QuestionList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuesionService {

  @Autowired
  QuestionList questionList;

    public List<Question> getAllQuestions() {
        return questionList.genquestionsList();
    }

    public List<Question> getGenQuestions(){
        return questionList.genquestionsList();
    }

    public List<Question> getMLQuestionsList(){
        return questionList.mlquestionsList();
    }

    public List<Question> getAiQuestions(){
        return questionList.aiquestionsList();
    }

    public List<Question> getDsaQuestions(){
        return questionList.dsaquestionsList();
    }
}

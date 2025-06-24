package com.service;

import com.mongo.model.QuestionModel;
import com.repository.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepo questionRepo;

    public List<QuestionModel> getQuestionsBySubject(String subjectId){

        return questionRepo.findQuestionBySubjectId(subjectId);
    }

    public QuestionModel addQuestionsBySubject(String subjectId, QuestionModel questionInfo){
        QuestionModel question = new QuestionModel();

        question.setQid(null);
        question.setSubjectId(subjectId);
        question.setQuestion(questionInfo.getQuestion());
        question.setAnswer(questionInfo.getAnswer());
        question.setOption1(questionInfo.getOption1());
        question.setOption2(questionInfo.getOption2());
        question.setOption3(questionInfo.getOption3());
        question.setOption4(questionInfo.getOption4());

        questionRepo.save(question);

        return questionInfo;

    }


}

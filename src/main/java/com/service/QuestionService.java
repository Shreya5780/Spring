package com.service;

import com.controller.SubjectController;
import com.mongo.model.QuestionModel;
import com.mongo.model.SubjectModel;
import com.repository.QuestionRepo;
import com.repository.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;

@Service
public class QuestionService {

    @Autowired
    QuestionRepo questionRepo;

    @Autowired
    SubjectRepo subjectRepo;

    public List<QuestionModel> getQuestionsBySubject(String subjectId){
        //i need to check if subject is present or not
        SubjectModel subject = subjectRepo.findById(subjectId).orElse(null);
        if (subject == null) {

            throw new IllegalArgumentException("Subject not found")  ;
        }

        return questionRepo.findQuestionBySubjectId(subjectId);
    }

    public QuestionModel addQuestionsBySubject(String subjectId, QuestionModel questionInfo){

        SubjectModel subject = subjectRepo.findById(subjectId).orElse(null);
        if (subject == null) {

            throw new IllegalArgumentException("Subject not found")  ;
        }

        QuestionModel question = new QuestionModel();

        question.setQid(null);
        question.setSubjectId(subjectId);
        question.setQuestion(questionInfo.getQuestion());
        question.setAnswer(questionInfo.getAnswer().toUpperCase());
        question.setOption1(questionInfo.getOption1());
        question.setOption2(questionInfo.getOption2());
        question.setOption3(questionInfo.getOption3());
        question.setOption4(questionInfo.getOption4());

        questionRepo.save(question);

        return questionInfo;

    }

    public QuestionModel updateQuestionsBySubject(String questionId, QuestionModel questionInfo){

        QuestionModel question = questionRepo.findById(questionId).orElse(null);

        if(question == null){
            throw new IllegalArgumentException("Question not found")  ;
        }

        SubjectModel subject = subjectRepo.findById(question.getSubjectId()).orElse(null);
        if (subject == null) {

            throw new NullPointerException("Subject name")  ;
        }

       if(questionInfo.getQuestion() != null)  question.setQuestion(questionInfo.getQuestion());
       if(questionInfo.getAnswer() != null) question.setAnswer(questionInfo.getAnswer());
       if(questionInfo.getOption1() != null) question.setOption1(questionInfo.getOption1());
       if(questionInfo.getOption2() != null) question.setOption2(questionInfo.getOption2());
       if(questionInfo.getOption3() != null) question.setOption3(questionInfo.getOption3());
       if(questionInfo.getOption4() != null) question.setOption4(questionInfo.getOption4());
       if(questionInfo.getSubjectId() != null) question.setSubjectId(questionInfo.getSubjectId());

       questionRepo.save(question);

        return question;

    }

    public ResponseEntity<String> deleteSubject(String questionId) {
        QuestionModel questionModel = questionRepo.findById(questionId).orElse(null);
        if (questionModel == null) {
            throw new IllegalArgumentException("Question not found")  ;
        }

        questionRepo.delete(questionModel);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Successfully deleted successfully");
    }


}

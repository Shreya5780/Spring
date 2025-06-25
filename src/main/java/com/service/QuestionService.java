package com.service;

import com.mongo.model.QuestionModel;
import com.mongo.model.SubjectModel;
import com.repository.QuestionRepo;
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

    public List<QuestionModel> getQuestionsBySubject(String subjectId){

        return questionRepo.findQuestionBySubjectId(subjectId);
    }

    public QuestionModel addQuestionsBySubject(String subjectId, QuestionModel questionInfo){
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
            System.out.println("Question not found.");
            return questionInfo;
        }

        /**
         * this is slower
         * so you can use this alternate also using if but this is difficult for large no. of fields
         */
//        Field[] fields = question.getClass().getDeclaredFields();
//        for(Field field : fields){
//            field.setAccessible(true);
//            System.out.println(field.getName());
//
//            try {
//               Object newValue = field.get(questionInfo);
//               if(newValue != null){
//                   field.set(question, newValue);
//                   System.out.println(newValue + " " + field.getName());
//               }
//               else{
////                   field.set(question, field.get(question));
//                   System.out.println(field.getName() + " " + field.get(question));
//               }
//            } catch (IllegalAccessException e) {
//                throw new RuntimeException(e);
//            }
//        }

       if(questionInfo.getQuestion() != null)  question.setQuestion(questionInfo.getQuestion());
       if(questionInfo.getAnswer() != null) question.setAnswer(questionInfo.getAnswer());
       if(questionInfo.getOption1() != null) question.setOption1(questionInfo.getOption1());
       if(questionInfo.getOption2() != null) question.setOption2(questionInfo.getOption2());
       if(questionInfo.getOption3() != null) question.setOption3(questionInfo.getOption3());
       if(questionInfo.getOption4() != null) question.setOption4(questionInfo.getOption4());

       questionRepo.save(question);

        return question;

    }

    public ResponseEntity<String> deleteSubject(@PathVariable String questionId) {
        QuestionModel questionModel = questionRepo.findById(questionId).orElse(null);
        if (questionModel == null) {
            return ResponseEntity.notFound().build();
        }
        questionRepo.delete(questionModel);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Successfully deleted successfully");
    }


}

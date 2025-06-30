package com.service;

import com.mongo.model.ScoreModel;
import com.mongo.model.SubjectModel;
import com.repository.QuestionRepo;
import com.repository.ScoreRepo;
import com.repository.SubjectRepo;
import org.example.quizeapp.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepo scoreRepo;

    @Autowired
    private SubjectRepo subjectRepo;

    public ScoreModel save(ScoreModel scoreModel) {
        ScoreModel score = new ScoreModel();

        score.setScoreId(null);
        score.setUserId(scoreModel.getUserId());
        score.setSubjectId(scoreModel.getSubjectId());
        score.setScore(scoreModel.getScore());

        return scoreRepo.save(scoreModel);
    }


    public List<ScoreModel> getAll(String subjectId) {
        SubjectModel subject = subjectRepo.findById(subjectId).orElse(null);
        if (subject == null) {

            throw new IllegalArgumentException("Subject not found")  ;
        }
        return scoreRepo.findAll();
    }

    public List<ScoreModel> getByUserId(String userId) {
        return scoreRepo.findByUserId(userId);
    }


    public List<ScoreModel> getAllBySubjectId(String subjectId) {
        SubjectModel subject = subjectRepo.findById(subjectId).orElse(null);
        if (subject == null) {

            throw new IllegalArgumentException("Subject not found")  ;
        }
        return scoreRepo.findBySubjectId(subjectId);
    }
}

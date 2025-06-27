package com.service;

import com.mongo.model.ScoreModel;
import com.repository.QuestionRepo;
import com.repository.ScoreRepo;
import org.example.quizeapp.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepo scoreRepo;

    public ScoreModel save(ScoreModel scoreModel) {
        ScoreModel score = new ScoreModel();

        score.setScoreId(null);
        score.setUserId(scoreModel.getUserId());
        score.setSubjectId(scoreModel.getSubjectId());
        score.setScore(scoreModel.getScore());

        return scoreRepo.save(scoreModel);
    }


    public List<ScoreModel> getAll(String subjectId) {

        return scoreRepo.findAll();
    }

    public List<ScoreModel> getByUserId(String userId) {
        return scoreRepo.findByUserId(userId);
    }


    public List<ScoreModel> getAllBySubjectId(String subjectId) {
        return scoreRepo.findBySubjectId(subjectId);
    }
}

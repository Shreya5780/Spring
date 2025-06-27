package com.controller;

import com.mongo.model.ScoreModel;
import com.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/score")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @PostMapping("/save")
    public ScoreModel save(@RequestBody ScoreModel scoreModel){
//        System.out.println(scoreModel.getScore());
//        System.out.println(scoreModel.getUserId());
//        System.out.println(scoreModel.getSubjectId());
        return scoreService.save(scoreModel);
    }

    @GetMapping("/getbysub/{subjectId}")
    public List<ScoreModel> get(@PathVariable String subjectId){
        return scoreService.getAllBySubjectId(subjectId);
    }

    @GetMapping("/getbyuser/{userId}")
    public List<ScoreModel> getByUserId(@PathVariable String userId){
        return scoreService.getByUserId(userId);
    }
}

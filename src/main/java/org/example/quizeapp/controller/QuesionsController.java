package org.example.quizeapp.controller;

import org.example.quizeapp.Question;
import org.example.quizeapp.service.QuesionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@Controller
@RequestMapping("/admin/questions")
public class QuesionsController {

    @Autowired
    private QuesionService quesionService;

    @RequestMapping("/getall")
//    @ResponseBody
//    @GetMapping("/getAllQuestion")
    public List<Question> getAllQuestion() {
        return quesionService.getAllQuestions();
    }

    @GetMapping("/general")
    public List<Question> getGenQuestion() {
        return quesionService.getGenQuestions();
    }

    @GetMapping("/ml")
    public List<Question> getMlQuestion() {
        return quesionService.getMLQuestionsList();
    }

    @GetMapping("/ai")
    public List<Question> getAiQuestion() {
        return quesionService.getAiQuestions();
    }

    @GetMapping("/dsa")
    public List<Question> getDsaQuestion() {
        return quesionService.getDsaQuestions();
    }
}

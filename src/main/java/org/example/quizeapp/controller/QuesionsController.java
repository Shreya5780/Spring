package org.example.quizeapp.controller;

import org.example.quizeapp.Question;
import org.example.quizeapp.service.QuesionServic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@Controller
@RequestMapping("/admin/questions")
public class QuesionsController {

    @Autowired
    private QuesionServic quesionServic;

    @RequestMapping("/getall")
//    @ResponseBody
//    @GetMapping("/getAllQuestion")
    public List<Question> getAllQuestion() {
        return quesionServic.getAllQuestions();
    }

    @GetMapping("/general")
    public List<Question> getGenQuestion() {
        return quesionServic.getGenQuestions();
    }

    @GetMapping("/ml")
    public List<Question> getMlQuestion() {
        return quesionServic.getMLQuestionsList();
    }

    @GetMapping("/ai")
    public List<Question> getAiQuestion() {
        return quesionServic.getAiQuestions();
    }

    @GetMapping("/dsa")
    public List<Question> getDsaQuestion() {
        return quesionServic.getDsaQuestions();
    }
}

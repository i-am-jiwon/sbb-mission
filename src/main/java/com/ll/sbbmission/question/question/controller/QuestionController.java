package com.ll.sbbmission.question.question.controller;

import com.ll.sbbmission.question.question.entity.Question;
import com.ll.sbbmission.question.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionRepository questionRepository;

    @GetMapping("/question/list")
    public String list(Model model){

        List<Question> questionsList = this.questionRepository.findAll();
        model.addAttribute("questionList", questionsList);

        return "question_list";
    }
}

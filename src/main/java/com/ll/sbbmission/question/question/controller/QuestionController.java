package com.ll.sbbmission.question.question.controller;

import com.ll.sbbmission.question.question.entity.Question;
import com.ll.sbbmission.question.question.repository.QuestionRepository;
import com.ll.sbbmission.question.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/list")
    public String list(Model model){

        List<Question> questionsList = this.questionService.getList();
        model.addAttribute("questionList", questionsList);

        return "question_list";
    }

    @GetMapping(value = "detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id){
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }

}


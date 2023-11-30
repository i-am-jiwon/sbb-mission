package com.ll.sbbmission.question.question.service;

import com.ll.sbbmission.question.question.entity.Question;
import com.ll.sbbmission.question.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public List<Question> getList(){
        return this.questionRepository.findAll();
    }

}

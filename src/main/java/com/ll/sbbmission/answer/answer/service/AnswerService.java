package com.ll.sbbmission.answer.answer.service;

import com.ll.sbbmission.answer.answer.entity.Answer;
import com.ll.sbbmission.answer.answer.repository.AnswerRepository;
import com.ll.sbbmission.question.question.entity.Question;
import com.ll.sbbmission.user.user.entity.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class AnswerService {

    private final AnswerRepository answerRepository;


    public void create(Question question, String content, SiteUser author) {
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setCreateDate(LocalDateTime.now());
        answer.setAuthor(author);
        answer.setQuestion(question);
        this.answerRepository.save(answer);
    }
}
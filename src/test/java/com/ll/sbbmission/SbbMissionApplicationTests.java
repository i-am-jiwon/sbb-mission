package com.ll.sbbmission;

import com.ll.sbbmission.answer.Answer;
import com.ll.sbbmission.answer.AnswerRepository;
import com.ll.sbbmission.question.Question;
import com.ll.sbbmission.question.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SbbApplicationTests {

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;

    @Test
    void testJpa1() {
        Question q1 = new Question();
        q1.setSubject("1");
        q1.setContent("1");
        q1.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q1);  // 첫번째 질문 저장

        Question q2 = new Question();
        q2.setSubject("스프링부트 모델 질문입니다.");
        q2.setContent("id는 자동으로 생성되나요?");
        q2.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q2);  // 두번째 질문 저장
    }

    @Test
    void testJpa2() {
        List<Question> all = this.questionRepository.findAll();
        //assertEquals(2, all.size());

        Question q = all.get(0);
        assertEquals("sbb가 무엇인가요?", q.getSubject());
    }
    @Test
    void testJpa3() {
        Optional<Question> oq = this.questionRepository.findById(1);
        if(oq.isPresent()){
            Question q = oq.get();
            assertEquals("sbb가 무엇인가요?", q.getSubject());
        }
    }
    @Test
    void testJpa4() {
        Question q = this.questionRepository.findBySubjectAndContent(
                "1", "1");
        assertEquals(1, q.getId());
    }

    @Test
    void testJpa5() {
        List<Question> qList = this.questionRepository.findBySubjectLike("1%");
        Question q = qList.get(0);
        assertEquals("1", q.getSubject());
    }

    @Test
    void testJpa6() {
        Optional<Question> oq = this.questionRepository.findById(1);
        assertTrue(oq.isPresent());
        Question q = oq.get();
        q.setSubject("new tite");
        this.questionRepository.save(q);
    }

    @Test
    void testJpa7() {
        assertEquals(2, this.questionRepository.count());
        Optional<Question> oq = this.questionRepository.findById(1);
        assertTrue(oq.isPresent());
        Question q = oq.get();
        this.questionRepository.delete(q);
        assertEquals(1, this.questionRepository.count());
    }

    @Test
    void testJpa8() {
        Optional<Question> oq = this.questionRepository.findById(2);
        assertTrue(oq.isPresent());
        Question q = oq.get();

        Answer a = new Answer();
        a.setContent("네 자동으로 생성됩니다.");
        a.setQuestion(q);
        a.setCreateDate(LocalDateTime.now());
        this.answerRepository.save(a);
    }
    @Test
    void testJpa9() {
        Optional<Answer> oa = this.answerRepository.findById(1);
        assertTrue(oa.isPresent());
        Answer a = oa.get();
        assertEquals(2, a.getQuestion().getId());
    }

    @Transactional
    @Test
    void testJpa10() {
        Optional<Question> oq = this.questionRepository.findById(2);
        assertTrue(oq.isPresent());
        Question q = oq.get();

        List<Answer> answerList = q.getAnswerList();

        assertEquals(1, answerList.size());
        assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
    }
}

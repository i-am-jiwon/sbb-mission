package com.ll.sbbmission.answer.answer.answerForm;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerForm {
    @NotEmpty(message = "not blank")
    private String content;
}

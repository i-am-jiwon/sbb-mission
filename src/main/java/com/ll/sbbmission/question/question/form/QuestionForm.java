package com.ll.sbbmission.question.question.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionForm {
    @NotEmpty(message = "title essential")
    @Size(max=200)
    private String subject;

    @NotEmpty(message = "body essential")
    private String content;
}

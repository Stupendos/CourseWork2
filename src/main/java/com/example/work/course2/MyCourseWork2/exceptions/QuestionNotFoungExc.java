package com.example.work.course2.MyCourseWork2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuestionNotFoungExc extends RuntimeException {
    public QuestionNotFoungExc() {
    }
    public QuestionNotFoungExc(String message) {
        super(message);
    }
}

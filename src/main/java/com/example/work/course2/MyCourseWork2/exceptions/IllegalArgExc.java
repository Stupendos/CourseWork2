package com.example.work.course2.MyCourseWork2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IllegalArgExc extends RuntimeException{
    public IllegalArgExc(){
        super("Неверное значение");
    }
}

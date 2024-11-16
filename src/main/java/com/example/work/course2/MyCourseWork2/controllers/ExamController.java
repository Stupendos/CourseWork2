package com.example.work.course2.MyCourseWork2.controllers;

import com.example.work.course2.MyCourseWork2.question.Question;
import com.example.work.course2.MyCourseWork2.services.ExaminerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/exam/questions")
    public List<Question> getQuestions(@RequestParam int amount) {
        return examinerService.getQuestions(amount);
    }
}

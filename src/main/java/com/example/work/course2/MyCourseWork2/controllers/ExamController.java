package com.example.work.course2.MyCourseWork2.controllers;

import com.example.work.course2.MyCourseWork2.question.Question;
import com.example.work.course2.MyCourseWork2.services.ExaminerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ExamController {
    private final ExaminerService examinerService;

    @GetMapping("/exam/questions")
    public Collection<Question> getQuestions(@RequestParam int amount) {
        return examinerService.getQuestions(amount);
    }
}

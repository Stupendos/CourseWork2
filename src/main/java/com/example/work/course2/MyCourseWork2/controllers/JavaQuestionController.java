package com.example.work.course2.MyCourseWork2.controllers;

import com.example.work.course2.MyCourseWork2.question.Question;
import com.example.work.course2.MyCourseWork2.services.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final QuestionService questionService;

    @GetMapping("/add")
    public String add(@RequestParam String question, @RequestParam String answer) {
        questionService.add(question, answer);
        return "Вопрос добавлен";
    }

    @PostMapping("/remove")
    public Question removeQuestion(@RequestParam String question, @RequestParam String answer) {
        return questionService.removeQuestion( new Question(question, answer));
    }

    @GetMapping
    public Collection<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }
}

package com.example.work.course2.MyCourseWork2.controllers;

import com.example.work.course2.MyCourseWork2.question.Question;
import com.example.work.course2.MyCourseWork2.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final QuestionService questionService;

    @Autowired
    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public String addQuestion(@RequestParam String question, @RequestParam String answer) {
        questionService.addQuestion(question, answer);
        return "Вопрос добавлен";
    }

    @PostMapping("/remove")
    public String removeQuestion(@RequestParam String question, @RequestParam String answer) {
        questionService.removeQuestion(question);
        return "Question removed successfully";
    }

    @GetMapping
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }
}

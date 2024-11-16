package com.example.work.course2.MyCourseWork2.services;

import com.example.work.course2.MyCourseWork2.exceptions.IllegalArgExc;
import com.example.work.course2.MyCourseWork2.question.Question;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public List<Question> getQuestions(int amount) {
        List<Question> allQuestions = questionService.getAllQuestions();
        if (amount > allQuestions.size()) {
            throw new IllegalArgExc();
        }
        Set<Question> uniqueQuestions = new HashSet<>();
        while (uniqueQuestions.size() < amount) {
            Question randomQuestion = questionService.getRandomQuestion();
            uniqueQuestions.add(randomQuestion);
        }
        return uniqueQuestions.stream().collect(Collectors.toList());
    }
}

package com.example.work.course2.MyCourseWork2.services;

import com.example.work.course2.MyCourseWork2.exceptions.BadRequest;
import com.example.work.course2.MyCourseWork2.exceptions.IllegalArgExc;
import com.example.work.course2.MyCourseWork2.question.Question;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.getAllQuestions().size()) {
        throw new BadRequest();
        }
        Set<Question> uniqueQuestions = new HashSet<>();
        while (uniqueQuestions.size() < amount) {
            Question randomQuestion = questionService.getRandomQuestion();
            uniqueQuestions.add(randomQuestion);
        }
        return new ArrayList<>(uniqueQuestions);
    }
}

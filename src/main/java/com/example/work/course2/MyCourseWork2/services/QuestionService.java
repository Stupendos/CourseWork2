package com.example.work.course2.MyCourseWork2.services;

import com.example.work.course2.MyCourseWork2.question.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionService {
    void addQuestion(String question, String answer);

    void removeQuestion(String question);

    List<Question> getAllQuestions();

    Question getRandomQuestion();
}

package com.example.work.course2.MyCourseWork2.services;

import com.example.work.course2.MyCourseWork2.exceptions.QuestionNotFoungExc;
import com.example.work.course2.MyCourseWork2.question.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final Set<Question> questions = new HashSet<>();
    private final Random random = new Random();

    @Override
    public Question add(String question, String answer) {
        return add (new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question removeQuestion(Question question) {
        questions.remove(question);
        return  question;
    }

    @Override
    public Collection<Question> getAllQuestions() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        return questions.stream()
                .skip(random.nextInt(questions.size()))
                .findFirst()
                .orElseThrow(QuestionNotFoungExc::new);
    }
}

package com.example.work.course2.MyCourseWork2.services;

import com.example.work.course2.MyCourseWork2.question.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionService {
    private final List<Question> questions;
    private final Random random = new Random();

    public JavaQuestionService() {
        this.questions = new ArrayList<>();
    }

    @Override
    public void addQuestion(String question, String answer) {
        questions.add(new Question(question, answer));
    }

    @Override
    public void removeQuestion(String question) {
        questions.removeIf(q -> q.getQuestion().equals(question));
    }

    @Override
    public List<Question> getAllQuestions() {
        return new ArrayList<>(questions);
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            throw new IllegalStateException("No questions were added to the list");
        }
        int randomIndex = random.nextInt(questions.size());
        return questions.get(randomIndex);
    }
}

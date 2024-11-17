package com.example.work.course2.MyCourseWork2.services;

import com.example.work.course2.MyCourseWork2.question.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {

    private JavaQuestionService javaQuestionService;

    @BeforeEach
    void setUp() {
        javaQuestionService = new JavaQuestionService();
    }

    @Test
    void add() {
        assertEquals(0, javaQuestionService.getAllQuestions().size());
        javaQuestionService.add("What is Java", "Language of programming");
        assertEquals(1, javaQuestionService.getAllQuestions().size());
    }

    @Test
    void removeQuestion() {
        Question question = new Question("What is Java", "Language of programming");
        javaQuestionService.add(question);
        assertEquals(1, javaQuestionService.getAllQuestions().size());
        javaQuestionService.removeQuestion(question);
        assertEquals(0, javaQuestionService.getAllQuestions().size());
    }

    @Test
    void getAllQuestions() {
        Question question = new Question("What is Java", "Language of programming");
        Question question1 = new Question("What is your version", "of course 17");
        javaQuestionService.add(question);
        javaQuestionService.add(question1);
        int questionCount = javaQuestionService.getAllQuestions().size();
        assertEquals(2, questionCount);
        assertTrue(javaQuestionService.getAllQuestions().stream().anyMatch(q -> q.getQuestion().equals("What is Java")));
        assertTrue(javaQuestionService.getAllQuestions().stream().anyMatch(q -> q.getQuestion().equals("What is your version")));
    }

    @Test
    void getRandomQuestion() {
        javaQuestionService.add("What is Java", "Language of programming");
        javaQuestionService.add("What is your version", "of course 17");
        Question randomQuestion = javaQuestionService.getRandomQuestion();
        assertNotNull(randomQuestion);
        assertTrue(
                randomQuestion.getQuestion().equals("What is Java") ||
                        randomQuestion.getQuestion().equals("What is your version"));
    }
}
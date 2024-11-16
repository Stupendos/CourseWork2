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
    void addQuestion() {
        Question question = new Question("What is Java", "Language of programming");
        javaQuestionService.addQuestion("What is Java", "Language of programming");
        assertEquals("What is Java", question.getQuestion());
        assertEquals("Language of programming", question.getAnswer());
    }

    @Test
    void removeQuestion() {
        Question question = new Question("What is Java", "Language of programming");
        javaQuestionService.addQuestion("What is Java", "Language of programming");
        assertEquals("What is Java", question.getQuestion());
        javaQuestionService.removeQuestion("What is Java");
        assertFalse(javaQuestionService.getAllQuestions().contains(question));
    }

    @Test
    void getAllQuestions() {
        Question question = new Question("What is Java", "Language of programming");
        Question question1 = new Question("What is your version", "of course 17");
        javaQuestionService.addQuestion("What is Java", "Language of programming");
        javaQuestionService.addQuestion("What is your version", "of course 17");
        assertEquals("What is Java", question.getQuestion());
        assertEquals("What is your version", question1.getQuestion());
        int questionCount = javaQuestionService.getAllQuestions().size();
        assertEquals(2, questionCount);
        assertTrue(javaQuestionService.getAllQuestions().stream().anyMatch(q -> q.getQuestion().equals("What is Java")));
        assertTrue(javaQuestionService.getAllQuestions().stream().anyMatch(q -> q.getQuestion().equals("What is your version")));
    }

    @Test
    void getRandomQuestion() {
        javaQuestionService.addQuestion("What is Java", "Language of programming");
        javaQuestionService.addQuestion("What is your version", "of course 17");
        Question randomQuestion = javaQuestionService.getRandomQuestion();
        assertNotNull(randomQuestion);
        assertTrue(
                randomQuestion.getQuestion().equals("What is Java") ||
                        randomQuestion.getQuestion().equals("What is your version"));
    }
}
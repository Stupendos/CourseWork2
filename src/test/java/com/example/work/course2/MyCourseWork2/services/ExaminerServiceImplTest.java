package com.example.work.course2.MyCourseWork2.services;

import com.example.work.course2.MyCourseWork2.question.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionService javaQuestionService;

    private ExaminerServiceImpl examinerServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        examinerServiceImpl = new ExaminerServiceImpl(javaQuestionService);
    }

    @Test
    void getQuestions() {
        Question question = new Question("What is Java","Language of programming");
        Question question1 = new Question("What is JVM","Java Virtual Machine");
        when(javaQuestionService.getRandomQuestion()).thenReturn(question, question1);

        List<Question> questions = examinerServiceImpl.getQuestions(2);
        assertEquals(2, questions.size());
        assertNotEquals(question.getQuestion(), question1.getQuestion());
    }
}
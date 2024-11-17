package com.example.work.course2.MyCourseWork2.services;

import com.example.work.course2.MyCourseWork2.exceptions.BadRequest;
import com.example.work.course2.MyCourseWork2.question.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService javaQuestionService;
    private final Question testQ = new Question("2", "3");
    private final Question testQ1 = new Question("1", "2");
    private final Question testQ2 = new Question("3", "1");

    @InjectMocks
    private ExaminerServiceImpl examinerServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        examinerServiceImpl = new ExaminerServiceImpl(javaQuestionService);
    }

    @Test
    void getQuestions() {
        when(javaQuestionService.getAllQuestions()).thenReturn(Arrays.asList(testQ, testQ1, testQ2));
        when(javaQuestionService.getRandomQuestion()).thenReturn(testQ, testQ1, testQ2);
        Collection<Question> questions = examinerServiceImpl.getQuestions(3);
        assertNotEquals(testQ.getQuestion(), testQ1.getQuestion(), testQ2.getQuestion());
        assertTrue(questions.containsAll(Arrays.asList(testQ, testQ1, testQ2)));
    }

    @Test
    void getQuestionAmountBig() {
        assertThrows(BadRequest.class, () ->
                examinerServiceImpl.getQuestions(1));
    }
}
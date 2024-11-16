package com.example.work.course2.MyCourseWork2.services;

import com.example.work.course2.MyCourseWork2.question.Question;

import java.util.List;

public interface ExaminerService {

    List<Question> getQuestions(int amount);
}

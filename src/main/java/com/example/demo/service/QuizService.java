package com.example.demo.service;

import com.example.demo.DAO.QuizRepository;
import com.example.demo.entity.Quiz;
import org.springframework.beans.factory.annotation.Autowired;

public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    public Quiz ajouterQuiz(Quiz q){
        return q;
    }
}

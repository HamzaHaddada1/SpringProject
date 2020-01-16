package com.example.demo.service;

import com.example.demo.DAO.QuizRepository;
import com.example.demo.entity.Quiz;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;


import static org.junit.jupiter.api.Assertions.*;

class QuizServiceTest {

    @InjectMocks
    private QuizService quizService;
    @Mock
    private QuizRepository quizRepository;

    @BeforeEach
    void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
    }
    @Test
    void ajouterQuizTest() throws Exception{
        Quiz q=new Quiz(12L,"Quiz1",20,"rep1");

        when(quizRepository.save(q)).thenReturn(q);
        assertEquals(quizService.ajouterQuiz(q),q);

    }
}
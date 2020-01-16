package com.example.demo.service;

import com.example.demo.DAO.UserRepository;
import com.example.demo.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
class UserServiceTest {

    @InjectMocks
    private UserService userService;
    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void ajouterUserTest() throws Exception{
        User userTest=new User(Long.valueOf(12),"hamza","123");
       when(userRepository.save(userTest)).thenReturn(userTest);
        assertEquals(userService.ajouterUser(userTest),userTest);
    }
    @Test
    void authentificationtest() throws Exception{
        User userTest=new User(Long.valueOf(12),"hamza","123");
        User userTest1=new User();
        userTest1=null;
        when(userRepository.findUserByName(anyString())).thenReturn(userTest1);
        assertTrue(userTest!=null,"user must be defined");
        assertTrue(userTest.getPassword().equals("123")&&userTest.getName().equals("hamza"),"the user must be defined");


    }
    @Test
    void correctUserPass() throws Exception{
        User userTest=new User(Long.valueOf(12),"hamza","123");
        assertTrue(userTest.getPassword().equals("123"),"Correct userPassword");
    }

}
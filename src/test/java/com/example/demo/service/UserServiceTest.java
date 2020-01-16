package com.example.demo.service;

import com.example.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {


    @Test
    void ajouterUserTest() throws Exception{
     UserService userService=new UserService();
        User userTest=new User(Long.valueOf(12),"hamza","123");
       assertEquals(userService.ajouterUser(userTest),userTest);
    }
   @Test
    void hellotest() throws Exception{
       UserService userService=new UserService();
        assertEquals(userService.hello("hamza"),"hamza");
    }
}
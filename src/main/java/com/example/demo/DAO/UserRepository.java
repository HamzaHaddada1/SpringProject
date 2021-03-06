package com.example.demo.DAO;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<User,Long> {
    User findUserById(Long id);
    boolean deleteUserById(Long id);
    User findUserByName(String name);
}

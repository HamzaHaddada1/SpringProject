package com.example.demo.controller;

import com.example.demo.DAO.UserRepository;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public User ajouterUser(@RequestBody User user){
        return userService.ajouterUser(user);
    }
    @PostMapping("/affecter/{idUser}/{idProduct}")
    public User affecterProduit(@PathVariable Long idUser,@PathVariable Long idProduct){
         userService.affecterProduct(idUser,idProduct);
         return userRepository.findUserById(idUser);
    }
    @GetMapping("{idUser}")
    public int countProducts(@PathVariable Long idUser){
        return userService.coutnProduct(idUser);
    }
    @GetMapping("/aut/{name}/{pass}")
    public boolean auth(@PathVariable String name,@PathVariable String pass){return userService.authentification(name,pass);}


}

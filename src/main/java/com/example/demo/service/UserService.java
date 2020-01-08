package com.example.demo.service;

import com.example.demo.DAO.ProductRepository;
import com.example.demo.DAO.UserRepository;
import com.example.demo.controller.ProductController;
import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;
    public User ajouterUser(User user){
        return userRepository.save(user);
    }

    public boolean supprimerUser(Long  id){
       return userRepository.deleteUserById(id);
    }

    public int coutnProduct(Long id){
      User  u=userRepository.findUserById(id);
        return u.getProducts().size();
    }
    public void affecterProduct(Long userId, Long productId){
        User u=userRepository.findUserById(userId);
       Product p=productRepository.findProductById(productId);
        u.addProduct(p);
         userRepository.save(u);
    }
    public boolean authentification(String name,String password){
        User u=userRepository.findUserByName(name);
        if(u==null) return false;
        else if(!u.getPassword().equals(password)) return false;
        return true;

    }


}

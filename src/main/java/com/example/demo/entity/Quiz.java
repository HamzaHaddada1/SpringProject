package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Quiz {
    @Id
    private Long id;
    private String name;
    private int score;
    private String reponse ;

    public Quiz(Long id,String name, int score, String reponse) {
        this.id=id;
        this.name = name;
        this.score = score;
        this.reponse = reponse;
    }
}

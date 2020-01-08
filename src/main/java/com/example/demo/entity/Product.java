package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Data
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    //private Date dateFabrication;
   // private Date endDate;
    private float price;
    //@Enumerated(EnumType.STRING)
    private Categorie categorie;
    @ManyToOne
    @JsonIgnore
   private User user;
    public enum Categorie {TShirt,Boots,Sockes};

    public Product() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product(Long id, String name, Date dateFabrication, Date endDate, float price, Categorie categorie) {
        this.id = id;
        this.name = name;
        //this.dateFabrication = dateFabrication;
      //  this.endDate = endDate;
        this.price = price;
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateFabrication=" + //dateFabrication +
                ", endDate=" +// endDate +
                ", price=" + price +
                ", categorie=" + categorie +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return id == product.id &&
                Float.compare(product.price, price) == 0 &&
                Objects.equals(name, product.name) &&
               // Objects.equals(dateFabrication, product.dateFabrication) &&
                //Objects.equals(endDate, product.endDate) &&
                categorie == product.categorie;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name,/* dateFabrication, endDate,*/ price, categorie);
    }
}

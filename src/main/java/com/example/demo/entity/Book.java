package com.example.demo.entity;

import com.example.demo.Validator.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "title")
    @NotEmpty(message = "title must not be empty")
    @Size(max = 50,min = 1,message = "title must be less than 50 char")
    private String title;
    @Column(name = "author")
    private  String author;
    @Column(name = "price")
    @NotNull(message = "price is required")
    private double price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    @ValidCategoryId
    private Category category;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ValidUserId
    private User user;
}

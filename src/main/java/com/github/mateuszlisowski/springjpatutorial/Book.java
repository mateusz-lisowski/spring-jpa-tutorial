package com.github.mateuszlisowski.springjpatutorial;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Book {

    @Id
    @GeneratedValue
    private UUID id;
    private String title;
    @Column(
            updatable = false
    )
    private String author;


    public Book() {}

}

package com.github.mateuszlisowski.springjpatutorial.book;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.github.mateuszlisowski.springjpatutorial.rent.Rent;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue
    private UUID id;
    private String title;
    private String author;
    @OneToMany(
            mappedBy = "book"
    )
    @JsonManagedReference
    private List<Rent> rents;

}

package com.github.mateuszlisowski.springjpatutorial.rent;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.github.mateuszlisowski.springjpatutorial.book.Book;
import com.github.mateuszlisowski.springjpatutorial.member.Member;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
public class Rent {

    @Id
    @GeneratedValue
    private UUID id;
    private Date rentStart;
    private Date rentEnd;
    private Date dueDate;
    @ManyToOne
    @JoinColumn(
            name = "member_id"
    )
    @JsonBackReference
    private Member member;
    @ManyToOne
    @JoinColumn(
            name = "book_id"
    )
    @JsonBackReference
    private Book book;

}

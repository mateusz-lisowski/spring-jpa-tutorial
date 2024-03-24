package com.github.mateuszlisowski.springjpatutorial.rent;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.github.mateuszlisowski.springjpatutorial.book.Book;
import com.github.mateuszlisowski.springjpatutorial.member.Member;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;

@Entity
@Data
public class Rent {

    @Id
    @UuidGenerator
    private String id;

    private Date rentStart;

    private Date rentEnd;

    private Date dueDate;

    @ManyToOne
    @JoinColumn(
            name = "member_id"
    )
    @JsonBackReference
    private Member member;

    private Book book;

}

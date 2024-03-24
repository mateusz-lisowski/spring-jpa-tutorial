package com.github.mateuszlisowski.springjpatutorial.member;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Data
public class Member {

    @Id
    @UuidGenerator
    private String id;
    private String firstName;
    private String lastName;

}

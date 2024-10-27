package com.github.mateuszlisowski.springjpatutorial.member;

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
public class Member {

    @Id
    private UUID id;
    private String firstName;
    private String lastName;
    @OneToMany(
            mappedBy = "member"
    )
    @JsonManagedReference
    private List<Rent> rents;


}

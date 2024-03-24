package com.github.mateuszlisowski.springjpatutorial.member;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.github.mateuszlisowski.springjpatutorial.rent.Rent;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@Entity
@Data
public class Member {

    @Id
    @UuidGenerator
    private String id;
    private String firstName;
    private String lastName;
    @OneToMany(
            mappedBy = "member"
    )
    @JsonManagedReference
    private List<Rent> rents;


}

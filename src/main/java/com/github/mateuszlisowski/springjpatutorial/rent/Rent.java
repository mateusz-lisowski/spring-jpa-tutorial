package com.github.mateuszlisowski.springjpatutorial.rent;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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

}

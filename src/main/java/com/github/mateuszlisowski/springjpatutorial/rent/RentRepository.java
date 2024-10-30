package com.github.mateuszlisowski.springjpatutorial.rent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RentRepository extends JpaRepository<Rent, UUID> {

}

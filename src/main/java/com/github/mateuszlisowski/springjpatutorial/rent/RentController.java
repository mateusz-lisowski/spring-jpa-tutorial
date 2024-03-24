package com.github.mateuszlisowski.springjpatutorial.rent;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rents")
@AllArgsConstructor
public class RentController {

    private final RentRepository repository;

    @GetMapping
    public List<Rent> readAllRents() {
        return repository.findAll();
    }

}

package com.github.mateuszlisowski.springjpatutorial.rent;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rents")
public class RentController {

    private final RentRepository repository;

    @GetMapping
    public List<Rent> readAllRents() {
        return repository.findAll();
    }

}

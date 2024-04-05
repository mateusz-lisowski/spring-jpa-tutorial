package com.github.mateuszlisowski.springjpatutorial.rent;

import com.github.mateuszlisowski.springjpatutorial.book.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rents")
public class RentController {

    private final RentService service;

}

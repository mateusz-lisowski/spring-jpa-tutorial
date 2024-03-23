package com.github.mateuszlisowski.springjpatutorial;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    private final BookRepository repository;

    public BookController(BookRepository bookRepository) {
        this.repository = bookRepository;
    }

    @PostMapping("/books")
    public Book create(
            @RequestBody Book book
    ) {
       return repository.save(book);
    }

}

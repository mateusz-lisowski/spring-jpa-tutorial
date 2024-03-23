package com.github.mateuszlisowski.springjpatutorial;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @GetMapping("/books")
    public List<Book> readAll() {
        return repository.findAll();
    }

    @GetMapping("/books/{book-id}")
    public Book readById(
            @PathVariable("book-id") UUID uuid
    ) {
        Optional<Book> book = repository.findById(uuid);
        if (book.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book with id " + uuid + " not found");
        }
        return book.get();
    }

}

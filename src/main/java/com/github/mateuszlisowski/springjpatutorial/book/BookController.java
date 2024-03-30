package com.github.mateuszlisowski.springjpatutorial.book;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class BookController {

    private final BookService service;

    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(
            @RequestBody BookSchema bookSchema
    ) {
       return service.createBook(bookSchema);
    }

    @GetMapping("/books")
    public List<Book> readAll() {
        return service.getAllBooks();
    }

    @GetMapping("/books/{book-id}")
    public Book readById(
            @PathVariable("book-id") UUID uuid
    ) {
       return service.getBookById(uuid);
    }

    @GetMapping("/books/search/{author}")
    public List<Book> readByAuthor(
            @PathVariable String author
    ) {
        return service.getAllBooksByAuthor(author);
    }

    @DeleteMapping("/books/{book-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable("book-id") UUID uuid
    ) {
       service.deleteBook(uuid);
    }

}

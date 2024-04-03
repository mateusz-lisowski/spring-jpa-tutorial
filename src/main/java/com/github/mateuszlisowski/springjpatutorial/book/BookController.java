package com.github.mateuszlisowski.springjpatutorial.book;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookSchema create(
            @RequestBody BookSchema schema
    ) {
        Book result = service.createBook(schema);
        return service.serializeBook(result);
    }

    @GetMapping
    public List<BookSchema> readAll() {
        List<Book> result = service.getAllBooks();
        return result.stream().map(service::serializeBook).collect(Collectors.toList());
    }

    @GetMapping("/{book-id}")
    public BookSchema readById(
            @PathVariable("book-id") UUID uuid
    ) {
        Book result = service.getBookById(uuid);
        return service.serializeBook(result);
    }

    @GetMapping("/search/{author}")
    public List<BookSchema> readByAuthor(
            @PathVariable String author
    ) {
        List<Book> result = service.getAllBooksByAuthor(author);
        return result.stream().map(service::serializeBook).collect(Collectors.toList());
    }

    @DeleteMapping("/{book-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable("book-id") UUID uuid
    ) {
       service.deleteBook(uuid);
    }

}

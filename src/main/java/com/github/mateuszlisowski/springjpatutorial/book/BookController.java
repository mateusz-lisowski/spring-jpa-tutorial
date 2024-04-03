package com.github.mateuszlisowski.springjpatutorial.book;

import com.github.mateuszlisowski.springjpatutorial.book.schemas.BookCreate;
import com.github.mateuszlisowski.springjpatutorial.book.schemas.BookResponse;
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
    public BookResponse create(
            @RequestBody BookCreate schema
    ) {
        Book result = service.createBook(schema);
        return service.serializeBook(result);
    }

    @GetMapping
    public List<BookResponse> readAll() {
        List<Book> result = service.getAllBooks();
        return result.stream().map(service::serializeBook).collect(Collectors.toList());
    }

    @GetMapping("/{book-id}")
    public BookResponse readById(
            @PathVariable("book-id") UUID uuid
    ) {
        Book result = service.getBookById(uuid);
        return service.serializeBook(result);
    }

    @GetMapping("/search/{author}")
    public List<BookResponse> readByAuthor(
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

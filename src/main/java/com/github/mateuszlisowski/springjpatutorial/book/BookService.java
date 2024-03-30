package com.github.mateuszlisowski.springjpatutorial.book;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository repository;

    public BookSchema serializeBook(Book book) {
        return new BookSchema(book.getTitle(), book.getAuthor());
    }

    public Book deserializeBook(BookSchema schema) {
       Book book = new Book();
       book.setTitle(schema.title());
       book.setAuthor(schema.author());
       return book;
    }

    public Optional<Book> getBookById(UUID uuid) {
        return repository.findById(uuid);
    }
}

package com.github.mateuszlisowski.springjpatutorial.book;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public Book createBook(BookSchema schema) {
        return repository.save(deserializeBook(schema));
    }

    public Optional<Book> getBookById(UUID uuid) {
        return repository.findById(uuid);
    }

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public void deleteBook(UUID uuid) {
        Optional<Book> book = getBookById(uuid);
        if (book.isEmpty()) {
            throw new RuntimeException("Book with id: " + uuid + " not found");
        }
        repository.delete(book.get());
    }

}

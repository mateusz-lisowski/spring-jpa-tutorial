package com.github.mateuszlisowski.springjpatutorial.book;

import com.github.mateuszlisowski.springjpatutorial.book.schemas.BookSchema;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public Book getBookById(UUID uuid) {
        Optional<Book> book = repository.findById(uuid);
        if (book.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book with id: " + uuid + " not found");
        }
        return book.get();
    }

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public List<Book> getAllBooksByAuthor(String author) {
        return repository.findAllByAuthor(author);
    }

    public void deleteBook(UUID uuid) {
        Book book = getBookById(uuid);
        repository.delete(book);
    }

}

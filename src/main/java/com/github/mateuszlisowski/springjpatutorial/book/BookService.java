package com.github.mateuszlisowski.springjpatutorial.book;

import com.github.mateuszlisowski.springjpatutorial.book.schemas.BookCreate;
import com.github.mateuszlisowski.springjpatutorial.book.schemas.BookResponse;
import com.github.mateuszlisowski.springjpatutorial.book.schemas.BookUpdate;
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

    public BookResponse serializeBook(Book book) {
        return new BookResponse(book.getId(), book.getTitle(), book.getAuthor());
    }

    public Book createBook(BookCreate schema) {
        Book book = new Book();
        book.setId(schema.id());
        book.setTitle(schema.title());
        book.setAuthor(schema.author());
        return repository.save(book);
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

    public Book updateBook(UUID uuid, BookUpdate updatedBook) {
        Optional<Book> book = repository.findById(uuid);
        if (book.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book with id: " + uuid + " not found");
        }
        Book bookToUpdate = book.get();
        bookToUpdate.setTitle(updatedBook.title());
        bookToUpdate.setAuthor(updatedBook.author());
        return repository.save(bookToUpdate);
    }

    public void deleteBook(UUID uuid) {
        Book book = getBookById(uuid);
        repository.delete(book);
    }

}

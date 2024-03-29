package com.github.mateuszlisowski.springjpatutorial.book;

import org.springframework.stereotype.Service;

@Service
public class BookService {

    public BookSchema serializeBook(Book book) {
        return new BookSchema(book.getTitle(), book.getAuthor());
    }

    public Book deserializeBook(BookSchema schema) {
       Book book = new Book();
       book.setTitle(schema.title());
       book.setAuthor(schema.author());
       return book;
    }

}

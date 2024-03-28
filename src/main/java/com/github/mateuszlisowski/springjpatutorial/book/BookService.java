package com.github.mateuszlisowski.springjpatutorial.book;

import org.springframework.stereotype.Service;

@Service
public class BookService {

    public BookSchema serializeBook(Book book) {
        return new BookSchema(book.getTitle(), book.getAuthor());
    }

}

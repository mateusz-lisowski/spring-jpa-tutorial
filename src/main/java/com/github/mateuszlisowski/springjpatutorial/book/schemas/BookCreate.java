package com.github.mateuszlisowski.springjpatutorial.book.schemas;

public record BookCreate(
        String title,
        String author
) {
}

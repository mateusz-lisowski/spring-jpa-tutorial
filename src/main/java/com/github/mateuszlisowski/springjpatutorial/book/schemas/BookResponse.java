package com.github.mateuszlisowski.springjpatutorial.book.schemas;

import java.util.UUID;

public record BookResponse(
        UUID id,
        String title,
        String author
) {
}

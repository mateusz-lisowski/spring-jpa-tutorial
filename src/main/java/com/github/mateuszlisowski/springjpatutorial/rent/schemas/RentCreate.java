package com.github.mateuszlisowski.springjpatutorial.rent.schemas;

import java.util.Date;
import java.util.UUID;

public record RentCreate(
        Date rentStart,
        Date rentEnd,
        Date dueDate,
        UUID memberId,
        UUID bookId
) {
}

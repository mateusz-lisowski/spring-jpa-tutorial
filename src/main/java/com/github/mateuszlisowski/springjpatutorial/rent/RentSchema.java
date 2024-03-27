package com.github.mateuszlisowski.springjpatutorial.rent;

import java.util.Date;
import java.util.UUID;

public record RentSchema(
        Date rentStart,
        Date rentEnd,
        Date dueDate,
        UUID memberId,
        UUID bookId
) {
}

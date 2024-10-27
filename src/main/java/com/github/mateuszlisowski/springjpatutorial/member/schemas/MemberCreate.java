package com.github.mateuszlisowski.springjpatutorial.member.schemas;

import java.util.UUID;

public record MemberCreate(
        UUID id,
        String firstName,
        String lastName
) {
}

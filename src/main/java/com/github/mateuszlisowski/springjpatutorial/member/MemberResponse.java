package com.github.mateuszlisowski.springjpatutorial.member;

import java.util.UUID;

public record MemberResponse(
        UUID id,
        String firstName,
        String lastName
) {
}

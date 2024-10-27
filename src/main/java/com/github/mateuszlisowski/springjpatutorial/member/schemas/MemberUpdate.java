package com.github.mateuszlisowski.springjpatutorial.member.schemas;

public record MemberUpdate(
        String firstName,
        String lastName
) {
}

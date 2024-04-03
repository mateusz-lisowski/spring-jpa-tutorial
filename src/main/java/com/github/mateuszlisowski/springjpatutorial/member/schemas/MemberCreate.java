package com.github.mateuszlisowski.springjpatutorial.member.schemas;

public record MemberCreate(
        String firstName,
        String lastName
) {
}

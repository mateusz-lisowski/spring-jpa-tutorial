package com.github.mateuszlisowski.springjpatutorial.member;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MemberService {

    private final MemberRepository repository;

    public MemberSchema serializeMember(Member member) {
        return new MemberSchema(member.getFirstName(), member.getLastName());
    }

    public Member deserializeMember(MemberSchema schema) {
        Member member = new Member();
        member.setFirstName(schema.firstName());
        member.setLastName(schema.lastName());
        return member;
    }

    public Optional<Member> getMemberById(UUID uuid) {
        return repository.findById(uuid.toString());
    }

}

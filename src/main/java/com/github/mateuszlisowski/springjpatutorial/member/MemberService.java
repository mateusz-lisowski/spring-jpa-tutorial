package com.github.mateuszlisowski.springjpatutorial.member;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
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

    public Member createMember(MemberSchema schema) {
        return repository.save(deserializeMember(schema));
    }

    public Member getMemberById(UUID uuid) {
        Optional<Member> member = repository.findById(uuid);
        if (member.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Member with id: " + uuid + " not found");
        }
        return member.get();
    }

    public List<Member> getAllMembers() {
        return repository.findAll();
    }

    public void deleteMember(UUID uuid) {
        Member member = getMemberById(uuid);
        repository.delete(member);
    }

}

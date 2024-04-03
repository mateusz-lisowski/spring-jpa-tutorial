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

    public MemberResponse serializeMember(Member member) {
        return new MemberResponse(member.getId(), member.getFirstName(), member.getLastName());
    }

    public Member createMember(MemberCreate schema) {
        Member member = new Member();
        member.setFirstName(schema.firstName());
        member.setLastName(schema.lastName());
        return repository.save(member);
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

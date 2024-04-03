package com.github.mateuszlisowski.springjpatutorial.member;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MemberResponse create(
            @RequestBody MemberCreate schema
    ) {
        Member result = service.createMember(schema);
        return service.serializeMember(result);
    }

    @GetMapping
    public List<MemberResponse> readAll() {
        List<Member> result = service.getAllMembers();
        return result.stream().map(service::serializeMember).collect(Collectors.toList());
    }

    @GetMapping("/{member-id}")
    public MemberResponse readById(
            @PathVariable("member-id") UUID uuid
    ) {
        Member result = service.getMemberById(uuid);
        return service.serializeMember(result);
    }

    @DeleteMapping("/{member-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable("member-id") UUID uuid
    ) {
       service.deleteMember(uuid);
    }
}

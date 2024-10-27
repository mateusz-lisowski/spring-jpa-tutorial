package com.github.mateuszlisowski.springjpatutorial.member;

import com.github.mateuszlisowski.springjpatutorial.book.Book;
import com.github.mateuszlisowski.springjpatutorial.book.schemas.BookResponse;
import com.github.mateuszlisowski.springjpatutorial.book.schemas.BookUpdate;
import com.github.mateuszlisowski.springjpatutorial.member.schemas.MemberCreate;
import com.github.mateuszlisowski.springjpatutorial.member.schemas.MemberResponse;
import com.github.mateuszlisowski.springjpatutorial.member.schemas.MemberUpdate;
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

    @PutMapping("/{member-id}")
    public MemberResponse updateMember(
            @PathVariable("member-id") UUID uuid,
            @RequestBody MemberUpdate schema
    ) {
        Member result = service.updateMember(uuid, schema);
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

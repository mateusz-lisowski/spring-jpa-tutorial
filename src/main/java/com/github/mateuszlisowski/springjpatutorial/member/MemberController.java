package com.github.mateuszlisowski.springjpatutorial.member;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberRepository repository;

    @GetMapping
    public List<Member> readAllMembers() {
       return repository.findAll();
    }

}

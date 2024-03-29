package com.github.mateuszlisowski.springjpatutorial.member;

public class MemberService {

    public MemberSchema serializeMember(Member member) {
        return new MemberSchema(member.getFirstName(), member.getLastName());
    }

    public Member deserializeMember(MemberSchema schema) {
        Member member = new Member();
        member.setFirstName(schema.firstName());
        member.setLastName(schema.lastName());
        return member;
    }

}

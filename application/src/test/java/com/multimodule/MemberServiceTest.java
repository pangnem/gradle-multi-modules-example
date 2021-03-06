package com.multimodule;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemberServiceTest {
    private MemberService memberService;

    @BeforeEach
    void setUp() {
        this.memberService = new MemberService(new InMemoryMemberRepository());

        memberService.createMember("setupMemberName");
    }

    @Test
    void createMemberWithStringTest() {
        Member savedMember = memberService.createMember("memberName");
        assertThat(savedMember.getName()).isEqualTo("memberName");
    }

    @Test
    void createMemberWithMembmerTest() {
        Member savedMember = memberService.createMember(new Member("memberName"));
        assertThat(savedMember.getName()).isEqualTo("memberName");
    }

    @Test
    void getAllMembersTest() {
        List<Member> allMembers = memberService.getAllMembers();
        assertThat(allMembers).hasSize(1);
    }
}

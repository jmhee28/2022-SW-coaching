package com.example.swcoaching.member;

import com.example.swcoaching.member.jpa.MemberEntity;
import com.example.swcoaching.member.jpa.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

    @DisplayName("ID로 회원 조회 한다")
    @Test
    void findByUsername() {
        // given
        MemberEntity memberEntity = mock(MemberEntity.class);
        MemberRepository memberRepository = mock(MemberRepository.class);

        long testMemberId = 1L;
        String testMemberUsername = "testUsername";
        String testMemberPassword = "testPassword";
        String testMemberName = "테스트 회원명";
        String testRemark = "회원 비고";

        when(memberEntity.getId()).thenReturn(testMemberId);
        when(memberEntity.getUsername()).thenReturn(testMemberUsername);
        when(memberEntity.getPassword()).thenReturn(testMemberPassword);
        when(memberEntity.getName()).thenReturn(testMemberName);
        when(memberEntity.getRemark()).thenReturn(testRemark);

        when(memberRepository.findByUsername(testMemberUsername)).thenReturn(memberEntity);

        // when
        MemberService memberService = new MemberServiceImpl(memberRepository);
        Member member = memberService.findByUsername(testMemberUsername);

        // then
        assertEquals(member.getId(), testMemberId);
        assertEquals(member.getUsername(), testMemberUsername);
        assertEquals(member.getPassword(), testMemberPassword);
        assertEquals(member.getName(), testMemberName);
        assertEquals(member.getRemark(), testRemark);
    }
}
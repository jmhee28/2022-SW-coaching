package com.example.swcoaching.member;

import com.example.swcoaching.member.jpa.MemberEntity;
import com.example.swcoaching.member.jpa.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

  private final MemberRepository memberRepository;

  public MemberServiceImpl(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  @Override
  public Member findByUsername(String username) {
    MemberEntity memberEntity = memberRepository.findByUsername(username);
    return Member.of(memberEntity);
  }
}
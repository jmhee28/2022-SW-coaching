package com.example.swcoaching.member.jpa;

import com.example.swcoaching.member.jpa.MemberEntity;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<MemberEntity, Long> {

  MemberEntity findByUsername(String username);
}
package com.example.swcoaching.member;

import com.example.swcoaching.member.jpa.MemberEntity;

public class Member {
  private final Long id;
  private final String username;
  private final String password;
  private final String name;
  private final String remark;

  public Member(Long id, String username, String password, String name, String remark) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.name = name;
    this.remark = remark;
  }

  public static Member of(MemberEntity memberEntity) {
    return new Member(memberEntity.getId(), memberEntity.getUsername(), memberEntity.getPassword(),
            memberEntity.getName(), memberEntity.getRemark());
  }

  public Long getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public String getName() {
    return name;
  }

  public String getRemark() {
    return remark;
  }
}
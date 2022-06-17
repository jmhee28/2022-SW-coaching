package com.example.swcoaching.board.jpa;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 게시물
 */
@Getter // 클래스 내 모든 필드의 Getter 메소드 자동생성
@Table(name = "post")
@Entity // 테이블과 링크될 클래스
public class PostEntity {
  @Id // 해당 테이블의 primary key 필드 
  @GeneratedValue(strategy = GenerationType.IDENTITY) //pk생성규칙
  private Long id;

  @Column(length = 1000) // 테이블의 칼럼
  private String title;

  @Column(columnDefinition = "text")
  private String contents;

  @ManyToOne
  @JoinColumn(name = "boardId")
  private BoardEntity board;

}
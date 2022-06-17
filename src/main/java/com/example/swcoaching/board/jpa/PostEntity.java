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
@Getter
@Table(name = "post")
@Entity
public class PostEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 1000)
  private String title;

  @Column(columnDefinition = "text")
  private String contents;

  @ManyToOne
  @JoinColumn(name = "boardId")
  private BoardEntity board;

}
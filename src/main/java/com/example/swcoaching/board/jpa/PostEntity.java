package com.example.swcoaching.board.jpa;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Optional;

/**
 * 게시물
 */
@NoArgsConstructor
@Getter // 클래스 내 모든 필드의 Getter 메소드 자동생성
@Table(name = "post")
@Entity // 테이블과 링크될 클래스, entity class 에서는 setter 절대 생성 x.
public class PostEntity{


  @Id // 해당 테이블의 primary key 필드 
  @GeneratedValue(strategy = GenerationType.IDENTITY) //pk생성규칙
  private Long id;

  @Column(length = 1000) // 테이블의 칼럼
  private String title;

  @Column(columnDefinition = "text")
  private String contents;
  @Column
  private Long viewcount;

  @Column
  private String author;
  @ManyToOne
  @JoinColumn(name = "board_id")
  private BoardEntity board;

  public PostEntity(String title, String contents, long id, String author) {
    this.title = title;
    this.contents = contents;
    this.id = id;
    this.author = author;
  }
   //게시글 수정
  public void update(String title, String contents) {
    this.title = title;
    this.contents = contents;
  }
  public void setBoard(BoardEntity board)
  {
    this.board= board;
  }
  public void addViewCount()
  {
    this.viewcount+=1;
  }
  public void ZeroViewCount()
  {
    this.viewcount = 0L ;
  }
}
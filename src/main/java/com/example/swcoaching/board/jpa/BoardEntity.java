package com.example.swcoaching.board.jpa;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Table(name = "board")
@Entity
public class BoardEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * 게시판 제목
   */
  @Column(length = 1000)
  private String title;

  /**
   * 게시판 설명
   */
  @Column(columnDefinition = "text")
  private String remark;
  @Column
  public Long totalcnt;
  /**
   * 게시물
   */
  @OneToMany(mappedBy = "board")
  public List<PostEntity> posts = new ArrayList<>();
  public BoardEntity(String title, String remark, long id) {
    this.title = title;
    this.remark = remark;
    this.id = id;
  }



  public void AddTotalCnt()
  {
    this.totalcnt+=1;
  }
  public void MinusTotalCnt()
  {
    this.totalcnt-=1;
  }
  public void ZeroCnt()
  {
    this.totalcnt = 0L;
  }
}
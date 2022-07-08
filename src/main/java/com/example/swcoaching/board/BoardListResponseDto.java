package com.example.swcoaching.board;

import com.example.swcoaching.board.jpa.BoardEntity;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class BoardListResponseDto {
    private Long id;
    private String title;
    private Long totalcnt;
    public BoardListResponseDto(BoardEntity entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.totalcnt = entity.getTotalcnt();
        }
}

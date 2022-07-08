package com.example.swcoaching.board;

import com.example.swcoaching.board.jpa.BoardEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardSaveRequestDto {
    private String title;
    private String remark;
    private long id;

    public BoardSaveRequestDto(String title, String remark, long id){
        this.title = title;
        this.remark = remark;
        this.id = id;
    }

    public BoardEntity toEntity() {
        BoardEntity boardEntity = new BoardEntity(title, remark, id);
        boardEntity.ZeroCnt();
        return boardEntity;
    }
}

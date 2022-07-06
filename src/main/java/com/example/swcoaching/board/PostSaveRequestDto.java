package com.example.swcoaching.board;

import com.example.swcoaching.board.jpa.BoardEntity;
import com.example.swcoaching.board.jpa.PostEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Getter
@NoArgsConstructor
public class PostSaveRequestDto {
    private String title;
    private String contents;
    private long id;


    public PostSaveRequestDto(String title, String contents, long pid){
        this.title = title;
        this.contents = contents;
        this.id = pid;

    }

    public PostEntity toEntity() {
       return new PostEntity(title, contents, id);//(access = AccessLevel.PRIVATE) -> of 사용

    }
}

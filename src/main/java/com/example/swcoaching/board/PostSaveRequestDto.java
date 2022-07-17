package com.example.swcoaching.board;

import com.example.swcoaching.board.jpa.PostEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostSaveRequestDto {
    private String title;
    private String contents;
    private long id;

    private String author;

    public PostSaveRequestDto(String title, String contents, long pid, String author){
        this.title = title;
        this.contents = contents;
        this.id = pid;
        this.author = author;
    }

    public PostEntity toEntity() {
       return new PostEntity(title, contents, id, author);//(access = AccessLevel.PRIVATE) -> of 사용

    }
}

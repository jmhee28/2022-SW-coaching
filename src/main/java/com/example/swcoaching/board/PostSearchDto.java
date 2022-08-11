package com.example.swcoaching.board;

import com.example.swcoaching.board.jpa.PostEntity;

public class PostSearchDto {

    private Long id;
    private String title;
    private String contents;

    private String author;

    public PostSearchDto(PostEntity entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.contents = entity.getContents();
        this.author = entity.getAuthor();
    }
}


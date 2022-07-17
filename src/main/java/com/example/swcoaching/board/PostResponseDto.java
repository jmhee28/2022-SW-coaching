package com.example.swcoaching.board;

public class PostResponseDto {
    private Long id;
    private String title;
    private String contents;


    public PostResponseDto(Post entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.contents = entity.getContents();

    }
}


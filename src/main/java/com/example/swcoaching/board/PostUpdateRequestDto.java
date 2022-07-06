package com.example.swcoaching.board;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostUpdateRequestDto {
    private String title;
    private String content;

    public PostUpdateRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}

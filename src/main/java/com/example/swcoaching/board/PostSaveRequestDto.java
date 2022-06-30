package com.example.swcoaching.board;

import com.example.swcoaching.board.jpa.PostEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostSaveRequestDto {
    private String title;
    private String contents;
    private long id;
    @Builder
    public PostSaveRequestDto(String title, String contents, long id) {
        this.title = title;
        this.contents = contents;
        this.id = id;
    }

    public PostEntity toEntity() {
        return PostEntity.builder()
                .id(id)
                .title(title)
                .contents(contents)
                .build();
    }
}

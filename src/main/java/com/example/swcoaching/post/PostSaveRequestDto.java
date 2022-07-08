package com.example.swcoaching.post;

import com.example.swcoaching.post.jpa.PostEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

package com.example.swcoaching.board.jpa;

import com.example.swcoaching.board.jpa.PostEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends CrudRepository<PostEntity, Long> {
    @Query("SELECT p FROM PostEntity p WHERE p.title = :title ORDER BY p.id ASC")
    List<PostEntity> findByTitle(@Param("title") String title);

    @Query("SELECT p FROM PostEntity p WHERE p.contents LIKE %:contents% ORDER BY p.id ASC")
    List<PostEntity> findByContentsContaining(@Param("contents") String contents);

    @Query("SELECT p FROM PostEntity p WHERE p.author = :author ORDER BY p.id ASC")
    List<PostEntity> findByAuthor(@Param("author") String author);
}

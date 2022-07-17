package com.example.swcoaching.board.jpa;

import com.example.swcoaching.board.jpa.PostEntity;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<PostEntity, Long> {
}

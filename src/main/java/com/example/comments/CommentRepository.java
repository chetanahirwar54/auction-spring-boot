package com.example.comments;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Yurii on 26.03.2017.
 */
public interface CommentRepository extends CrudRepository<Comment, String> {

    public List<Comment> findByFromWhomUsername (String username);
    public List<Comment> findByToWhomUsername (String username);
}

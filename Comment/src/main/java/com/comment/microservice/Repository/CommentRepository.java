package com.comment.microservice.Repository;

import com.comment.microservice.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, String> {
    List<Comment> findByPostId(String postId);
}

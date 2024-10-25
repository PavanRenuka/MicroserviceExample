package com.post.Microservice.repository;

import com.post.Microservice.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, String> {
}

package com.post.Microservice.services;

import com.post.Microservice.entities.Post;
import com.post.Microservice.payload.PostDto;

public interface PostService {

    Post  savePost(Post post);

    Post getPostById(String postId);

    PostDto getPostWithComment(String postId);
}

package com.post.Microservice.services.Impl;

import com.post.Microservice.Config.RestTemplateConfig;
import com.post.Microservice.entities.Post;
import com.post.Microservice.payload.PostDto;
import com.post.Microservice.repository.PostRepository;
import com.post.Microservice.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;
    
    @Autowired
    private RestTemplateConfig restTemplate;

    @Override
    public Post savePost(Post post) {
        String postId = UUID.randomUUID().toString();
        post.setPostId(postId);
        Post savedPost = postRepository.save(post);
        return savedPost;
    }

    @Override
    public Post getPostById(String postId) {
        Post post = postRepository.findById(postId).get();
        return post;
    }

    @Override
    public PostDto getPostWithComment(String postId) {
        Post post = postRepository.findById(postId).get();
        ArrayList comments = restTemplate.getRestTemplate().getForObject
                ("http://COMMENT/api/comments/" + postId, ArrayList.class);
        PostDto postDto= new PostDto();
        postDto.setPostId(post.getPostId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());
        postDto.setComment(comments);
        return postDto;
    }
}

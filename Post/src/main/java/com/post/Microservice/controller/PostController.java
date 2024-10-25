package com.post.Microservice.controller;

import com.post.Microservice.entities.Post;
import com.post.Microservice.payload.PostDto;
import com.post.Microservice.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    //http://localhost:8081/api/posts
    @PostMapping
    public ResponseEntity<Post> savePost(@RequestBody  Post post){
        Post savedPost = postService.savePost(post);
        return new ResponseEntity<>(savedPost, HttpStatus.CREATED);
    }

  //  http://localhost:8081/api/posts/{postId/comments
    @GetMapping("/{postId}")
    public Post getPost(@PathVariable String postId ){
        Post post = postService.getPostById(postId);
        return post;
    }

    @GetMapping("/{postId}/comments")
    public ResponseEntity<PostDto> getPostWithComment(@PathVariable String postId){
        PostDto postDto= postService.getPostWithComment(postId);
        return new ResponseEntity<>(postDto,HttpStatus.OK);
    }
}

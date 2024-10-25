package com.comment.microservice.controller;

import com.comment.microservice.entity.Comment;
import com.comment.microservice.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/comments")
public class commentController {
    @Autowired
    private CommentService commentService;

    @PostMapping
    public ResponseEntity<Comment> saveComment(@RequestBody Comment comment){
        Comment newComment = commentService.saveComment(comment);
        return new ResponseEntity<>(newComment, HttpStatus.OK);
    }

    @GetMapping("{postId}")
    public List<Comment> getAllCommentsByPostId(@PathVariable String postId){
        List<Comment> comments=commentService.getAllCommentsByPostId(postId);
        return comments;
    }
}

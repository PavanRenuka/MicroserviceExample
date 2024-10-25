package com.post.Microservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="posts")
public class Post {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String postId;
    private String title;
    private String content;
    private String description;
}

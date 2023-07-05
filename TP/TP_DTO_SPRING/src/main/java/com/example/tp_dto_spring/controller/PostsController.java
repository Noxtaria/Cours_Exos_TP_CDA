package com.example.tp_dto_spring.controller;

import com.example.tp_dto_spring.dto.CommentsDto;
import com.example.tp_dto_spring.dto.PostsDto;
import com.example.tp_dto_spring.entity.Comments;
import com.example.tp_dto_spring.entity.Posts;
import com.example.tp_dto_spring.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostsController {
    private final PostService postService;

    @Autowired
    public PostsController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<Posts> createPost(@RequestBody PostsDto postsDto) {
        Posts createdPost = postService.createPost(postsDto);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<Posts> getPostById(@PathVariable Long postId) {
        Posts posts = postService.getPostById(postId);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<Posts> updatePost(@PathVariable Long postId, @RequestBody PostsDto postsDto ) {
        Posts updatedPost = postService.updatePost(postId,postsDto);
        return new ResponseEntity<>(updatedPost, HttpStatus.OK);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
        return new ResponseEntity<>("Post supprimé avec succès", HttpStatus.OK);
    }

    @PostMapping("/{postId}/comments")
    public ResponseEntity<Comments> createComment(@PathVariable Long postId, @RequestBody CommentsDto commentsDto) {
        Comments createdComment = postService.createComment(postId, commentsDto);
        return new ResponseEntity<>(createdComment, HttpStatus.CREATED);
    }

    @GetMapping("/{postId}/comments/{commentId}")
    public ResponseEntity<Comments> getCommentById(@PathVariable Long postId,@PathVariable Long commentId) {
    Comments comments = postService.getCommentById(postId, commentId);
    return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @PutMapping("/{postId}/comments/{commentId}")
    public ResponseEntity<Comments> updateComment(@PathVariable Long postId, @PathVariable Long commentId, @RequestBody CommentsDto commentsDto) {
        Comments updatedComment = postService.updateComment(postId, commentId, commentsDto);
        return new ResponseEntity<>(updatedComment, HttpStatus.OK);
    }

    @DeleteMapping("/{postId}/comments/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable Long postId, @PathVariable Long commentId) {
        postService.deleteComment(postId, commentId);
        return new ResponseEntity<>("Comment supprimé avec succès", HttpStatus.OK);
    }
}

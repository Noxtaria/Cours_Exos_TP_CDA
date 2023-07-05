package com.example.tp_dto_spring.controller;

import com.example.tp_dto_spring.dto.CommentsDto;
import com.example.tp_dto_spring.entity.Comments;
import com.example.tp_dto_spring.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentsController {
    private final CommentService commentService;

    @Autowired
    public CommentsController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/{postId}")
    public ResponseEntity<Comments> createComment(@PathVariable Long postId, @RequestBody CommentsDto commentsDto) {
        Comments createdComment = commentService.createComment(postId, commentsDto);
        return new ResponseEntity<>(createdComment, HttpStatus.CREATED);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<List<Comments>> getCommentsByPostId(@PathVariable Long postId) {
        List<Comments> comments = commentService.getCommentsByPostId(postId);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @GetMapping("/{postId}/{commentId}")
    public ResponseEntity<Comments> getCommentById(@PathVariable Long postId, @PathVariable Long commentId) {
        Comments comments = commentService.getCommentById(postId, commentId);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @PutMapping("/{postId}/{commentId}")
    public ResponseEntity<Comments> updateComment(@PathVariable Long postId, @PathVariable Long commentId, @RequestBody CommentsDto commentsDto) {
        Comments updatedComment = commentService.updateComment(postId, commentId, commentsDto);
        return new ResponseEntity<>(updatedComment, HttpStatus.OK);
    }

    @DeleteMapping("/{postId}/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable Long postId, @PathVariable Long commentId) {
        commentService.deleteComment(postId, commentId);
        return new ResponseEntity<>("Comment supprimé avec succès", HttpStatus.OK);
    }
}

package com.example.tp_dto_spring.service;

import com.example.tp_dto_spring.dto.CommentsDto;
import com.example.tp_dto_spring.entity.Comments;
import com.example.tp_dto_spring.entity.Posts;
import com.example.tp_dto_spring.repository.CommentsRepository;
import com.example.tp_dto_spring.repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentsRepository commentsRepository;
    private final PostsRepository postsRepository;

    @Autowired
    public CommentService(CommentsRepository commentsRepository, PostsRepository postsRepository) {
        this.commentsRepository = commentsRepository;
        this.postsRepository = postsRepository;
    }

    public Comments createComment(Long postId, CommentsDto commentsDto) {
        Comments comments = new Comments();
        comments.setBody(commentsDto.getBody());
        comments.setName(commentsDto.getName());
        comments.setEmail(commentsDto.getEmail());
        Posts posts = new Posts();
        posts.setId(postId);
        comments.setPosts(posts);
        return commentsRepository.save(comments);
    }

    public List<Comments> getCommentsByPostId(Long postId) {
        return commentsRepository.findByPostsId(postId);
    }

    public Comments getCommentById(Long postId, Long commentId) {
        return commentsRepository.findByIdAndPostsId(commentId, postId)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
    }

    public Comments updateComment(Long postId, Long commentId, CommentsDto commentsDto) {
        Comments comments = getCommentById(postId, commentId);
        comments.setBody(commentsDto.getBody());
        comments.setName(commentsDto.getName());
        comments.setEmail(commentsDto.getEmail());
        return commentsRepository.save(comments);
    }

    public void deleteComment(Long postId, Long commentId) {
        Comments comments = getCommentById(postId, commentId);
        commentsRepository.delete(comments);
    }

    public Comments getCommentWithPosts(Long commentId) {
        Comments comment = commentsRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
        comment.getPosts();
        return comment;
    }

}

package com.example.tp_dto_spring.service;

import com.example.tp_dto_spring.dto.CommentsDto;
import com.example.tp_dto_spring.dto.PostsDto;
import com.example.tp_dto_spring.entity.Comments;
import com.example.tp_dto_spring.entity.Posts;
import com.example.tp_dto_spring.repository.CommentsRepository;
import com.example.tp_dto_spring.repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private final PostsRepository postsRepository;
    private final CommentsRepository commentsRepository;

    @Autowired
    public PostService(PostsRepository postsRepository, CommentsRepository commentsRepository) {
        this.postsRepository = postsRepository;
        this.commentsRepository = commentsRepository;
    }

    public Posts createPost(PostsDto postsDto) {
        Posts posts = new Posts();
        posts.setTitle(postsDto.getTitle());
        posts.setContent(postsDto.getContent());
        posts.setDescription(postsDto.getDescription());
        return postsRepository.save(posts);
    }

    public Posts getPostById(Long postId) {
        return postsRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post non trouvé"));
    }

    public Posts updatePost(Long postId, PostsDto postsDto) {
        Posts posts = getPostById(postId);
        posts.setTitle(postsDto.getTitle());
        posts.setContent(postsDto.getContent());
        posts.setDescription(postsDto.getDescription());
        return postsRepository.save(posts);
    }

    public void deletePost(Long postId) {
        Posts posts = getPostById(postId);
        postsRepository.delete(posts);
    }

    public Comments createComment(Long postId, CommentsDto commentsDto) {
        Posts posts = getPostById(postId);
        Comments comments = new Comments();
        comments.setBody(commentsDto.getBody());
        comments.setName(commentsDto.getName());
        comments.setEmail(commentsDto.getEmail());
        comments.setPosts(posts);
        return commentsRepository.save(comments);
    }

    public Comments getCommentById(Long postId, Long commentId) {
        return commentsRepository.findByIdAndPostsId(commentId, postId)
                .orElseThrow(() -> new RuntimeException("Commentaire non trouvé"));
    }

    public void deleteComment(Long postId, Long commentId) {
        Comments comments = getCommentById(postId, commentId);
        commentsRepository.delete(comments);
    }

    public Comments updateComment(Long postId, Long commentId, CommentsDto commentsDto) {
        Comments comments = getCommentById(postId, commentId);
        comments.setBody(commentsDto.getBody());
        comments.setName(commentsDto.getName());
        comments.setEmail(commentsDto.getEmail());
        return commentsRepository.save(comments);
    }
}

package com.example.tp07072023gestionposts.service;

import com.example.tp07072023gestionposts.entity.Comment;
import com.example.tp07072023gestionposts.exception.NotFoundException;
import com.example.tp07072023gestionposts.repository.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment getComment(Long commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(() -> new NotFoundException("Commentaire non trouvé"));
    }

    public Comment updateComment(Long commentId, Comment comment) {
        if (!commentRepository.existsById(commentId)) {
            throw new NotFoundException("Commentaire non trouvé");
        }
        comment.setId(commentId);
        return commentRepository.save(comment);
    }

    public void deleteComment(Long commentId) {
        if (!commentRepository.existsById(commentId)) {
            throw new NotFoundException("Commentaire non trouvé");
        }
        commentRepository.deleteById(commentId);
    }
}


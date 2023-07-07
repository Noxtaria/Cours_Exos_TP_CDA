package com.example.tp07072023gestionposts.service;

import com.example.tp07072023gestionposts.entity.Post;
import com.example.tp07072023gestionposts.exception.NotFoundException;
import com.example.tp07072023gestionposts.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public Post getPost(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new NotFoundException("Post non trouvé"));
    }

    public Post updatePost(Long postId, Post post) {
        if (!postRepository.existsById(postId)) {
            throw new NotFoundException("Post non trouvé");
        }
        post.setId(postId);
        return postRepository.save(post);
    }

    public void deletePost(Long postId) {
        if (!postRepository.existsById(postId)) {
            throw new NotFoundException("Post non trouvé");
        }
        postRepository.deleteById(postId);
    }
}
package com.example.tp07072023gestionposts.service;

import com.example.tp07072023gestionposts.entity.Like;
import com.example.tp07072023gestionposts.exception.NotFoundException;
import com.example.tp07072023gestionposts.repository.LikeRepository;
import org.springframework.stereotype.Service;

@Service
public class LikeService {

    private final LikeRepository likeRepository;

    public LikeService(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    public Like createLike(Like like) {
        return likeRepository.save(like);
    }

    public Like getLike(Long likeId) {
        return likeRepository.findById(likeId)
                .orElseThrow(() -> new NotFoundException("Like non trouvé"));
    }

    public void deleteLike(Long likeId) {
        if (!likeRepository.existsById(likeId)) {
            throw new NotFoundException("Like non trouvé");
        }
        likeRepository.deleteById(likeId);
    }
}

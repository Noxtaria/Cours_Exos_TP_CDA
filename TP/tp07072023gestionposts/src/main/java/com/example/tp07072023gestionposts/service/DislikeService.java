package com.example.tp07072023gestionposts.service;

import com.example.tp07072023gestionposts.entity.Dislike;
import com.example.tp07072023gestionposts.exception.NotFoundException;
import com.example.tp07072023gestionposts.repository.DislikeRepository;
import org.springframework.stereotype.Service;

@Service
public class DislikeService {

    private final DislikeRepository dislikeRepository;

    public DislikeService(DislikeRepository dislikeRepository) {
        this.dislikeRepository = dislikeRepository;
    }

    public Dislike createDislike(Dislike dislike) {
        return dislikeRepository.save(dislike);
    }

    public Dislike getDislike(Long dislikeId) {
        return dislikeRepository.findById(dislikeId)
                .orElseThrow(() -> new NotFoundException("Dislike non trouvé"));
    }

    public void deleteDislike(Long dislikeId) {
        if (!dislikeRepository.existsById(dislikeId)) {
            throw new NotFoundException("Dislike non trouvé");
        }
        dislikeRepository.deleteById(dislikeId);
    }
}


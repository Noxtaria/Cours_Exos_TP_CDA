package com.example.tp07072023gestionposts.controller;

import com.example.tp07072023gestionposts.entity.Like;
import com.example.tp07072023gestionposts.service.LikeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/likes")
public class LikeController {

    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping
    public ResponseEntity<Like> createLike(@RequestBody Like like) {
        Like createdLike = likeService.createLike(like);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLike);
    }

    @GetMapping("/{likeId}")
    public ResponseEntity<Like> getLike(@PathVariable Long likeId) {
        Like like = likeService.getLike(likeId);
        return ResponseEntity.ok(like);
    }

    @DeleteMapping("/{likeId}")
    public ResponseEntity<Void> deleteLike(@PathVariable Long likeId) {
        likeService.deleteLike(likeId);
        return ResponseEntity.noContent().build();
    }
}

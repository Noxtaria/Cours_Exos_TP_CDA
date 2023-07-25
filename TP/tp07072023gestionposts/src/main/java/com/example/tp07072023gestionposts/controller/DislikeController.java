package com.example.tp07072023gestionposts.controller;

import com.example.tp07072023gestionposts.entity.Dislike;
import com.example.tp07072023gestionposts.service.DislikeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dislikes")
public class DislikeController {

    private final DislikeService dislikeService;

    public DislikeController(DislikeService dislikeService) {
        this.dislikeService = dislikeService;
    }

    @PostMapping
    public ResponseEntity<Dislike> createDislike(@RequestBody Dislike dislike) {
        Dislike createdDislike = dislikeService.createDislike(dislike);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDislike);
    }

    @GetMapping("/{dislikeId}")
    public ResponseEntity<Dislike> getDislike(@PathVariable Long dislikeId) {
        Dislike dislike = dislikeService.getDislike(dislikeId);
        return ResponseEntity.ok(dislike);
    }

    @DeleteMapping("/{dislikeId}")
    public ResponseEntity<Void> deleteDislike(@PathVariable Long dislikeId) {
        dislikeService.deleteDislike(dislikeId);
        return ResponseEntity.noContent().build();
    }
}

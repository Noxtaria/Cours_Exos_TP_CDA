package com.example.controller;

import com.example.entity.Rapport;
import com.example.service.RapportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/rapports")
public class RapportController {

    private final RapportService rapportService;

    @Autowired
    public RapportController(RapportService rapportService) {
        this.rapportService = rapportService;
    }

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Rapport> creerRapport(@RequestBody Rapport rapport) {
        Rapport nouveauRapport = rapportService.creerRapport(rapport);
        return ResponseEntity.status(HttpStatus.CREATED).body(nouveauRapport);
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Rapport> trouverRapportParId(@PathVariable Long id) {
        Rapport rapport = rapportService.trouverRapportParId(id);
        if (rapport != null) {
            return new ResponseEntity<>(rapport, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<Rapport>> trouverRapportsParLocalisation(
            @RequestParam double latitude,
            @RequestParam double longitude
    ) {
        List<Rapport> rapports = rapportService.trouverRapportsParLocalisation(latitude, longitude);
        return new ResponseEntity<>(rapports, HttpStatus.OK);
    }

}

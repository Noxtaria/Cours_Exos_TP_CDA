package com.example.airquality.api.controller;

import com.example.airquality.domain.entity.Rapport;
import com.example.airquality.domain.service.RapportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/rapports")
public class RapportController {

    private final RapportService rapportService;

    @Autowired
    public RapportController(RapportService rapportService) {
        this.rapportService = rapportService;
    }

    @PostMapping
    public ResponseEntity<Rapport> createRapport(@RequestBody Rapport rapport) {
        Rapport createdRapport = rapportService.createRapport(rapport);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRapport);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rapport> getRapportById(@PathVariable Long id) {
        Rapport rapport = rapportService.getRapportById(id);
        if (rapport != null) {
            return ResponseEntity.ok(rapport);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/byLocation")
    public ResponseEntity<List<Rapport>> getRapportsByLocation(@RequestParam double latitude, @RequestParam double longitude) {
        List<Rapport> rapports = rapportService.getRapportsByLocation(latitude, longitude);
        return ResponseEntity.ok(rapports);
    }

    @GetMapping("/byDate")
    public ResponseEntity<List<Rapport>> getRapportsByDate(@RequestParam String date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime parsedDate = LocalDateTime.parse(date, formatter);
            List<Rapport> rapports = rapportService.getRapportsByDate(parsedDate);
            return ResponseEntity.ok(rapports);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/recent")
    public ResponseEntity<List<Rapport>> getRecentRapports() {
        List<Rapport> rapports = rapportService.getRecentRapports();
        return ResponseEntity.ok(rapports);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateRapport(@PathVariable Long id, @RequestBody Rapport rapport) {
        Rapport existingRapport = rapportService.getRapportById(id);
        if (existingRapport != null) {
            rapport.setId(id);
            rapportService.updateRapport(rapport);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRapport(@PathVariable Long id) {
        Rapport existingRapport = rapportService.getRapportById(id);
        if (existingRapport != null) {
            rapportService.deleteRapport(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

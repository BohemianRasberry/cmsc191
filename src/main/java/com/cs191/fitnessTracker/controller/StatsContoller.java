package com.cs191.fitnessTracker.controller;

import com.cs191.fitnessTracker.dto.GraphDTO;
import com.cs191.fitnessTracker.service.stats.StatsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class StatsContoller {
    private final StatsService statsService;

    public StatsContoller(StatsService statsService) {
        this.statsService = statsService;
    }

    @GetMapping("/stats")
    public ResponseEntity<?> getStats(){
        return ResponseEntity.ok(statsService.getStats());
    }

    @GetMapping("/graphs")
    public ResponseEntity<?> getGraphStats(){
        GraphDTO graphDTO = statsService.getGraphStats();
        if(graphDTO != null){
            return ResponseEntity.ok(graphDTO);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }
}

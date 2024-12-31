package com.cs191.fitnessTracker.controller;

import com.cs191.fitnessTracker.dto.ActivityDTO;
import com.cs191.fitnessTracker.service.activity.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ActivityController {
    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @PostMapping("/activity")
    public ResponseEntity<?> postActivity(@RequestBody ActivityDTO activityDTO){
        ActivityDTO createActivity = activityService.postActivity(activityDTO);

        if (createActivity != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(createActivity);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }

    @GetMapping("/activities")
    public ResponseEntity<?> getActivities(){
        try {
            return ResponseEntity.ok(activityService.getActivities());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }
}

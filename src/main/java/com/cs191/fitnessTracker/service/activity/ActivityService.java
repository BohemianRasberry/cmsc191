package com.cs191.fitnessTracker.service.activity;

import com.cs191.fitnessTracker.dto.ActivityDTO;

import java.util.List;

public interface ActivityService {
    ActivityDTO postActivity(ActivityDTO activityDTO);
    public List<ActivityDTO> getActivities();
}

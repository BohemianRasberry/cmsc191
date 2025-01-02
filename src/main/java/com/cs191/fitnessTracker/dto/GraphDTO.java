package com.cs191.fitnessTracker.dto;

import com.cs191.fitnessTracker.entity.Activity;

import java.util.List;

public class GraphDTO {
    private List<WorkoutDTO> workouts;
    private List<ActivityDTO> activities;

    public List<WorkoutDTO> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<WorkoutDTO> workouts) {
        this.workouts = workouts;
    }

    public List<ActivityDTO> getActivities() {
        return activities;
    }

    public void setActivities(List<ActivityDTO> activities) {
        this.activities = activities;
    }
}

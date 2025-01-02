package com.cs191.fitnessTracker.service.workout;

import com.cs191.fitnessTracker.dto.WorkoutDTO;

import java.util.List;

public interface WorkoutService {
    public WorkoutDTO postWorkout(WorkoutDTO workoutDTO);
    public List<WorkoutDTO> getWorkouts();
}

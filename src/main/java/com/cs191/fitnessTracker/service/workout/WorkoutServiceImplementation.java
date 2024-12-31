package com.cs191.fitnessTracker.service.workout;

import com.cs191.fitnessTracker.dto.WorkoutDTO;
import com.cs191.fitnessTracker.entity.Workout;
import com.cs191.fitnessTracker.repository.WorkoutRepository;
import org.springframework.stereotype.Service;

@Service
public class WorkoutServiceImplementation implements WorkoutService {
    private final WorkoutRepository workoutRepository;

    public WorkoutServiceImplementation(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    public WorkoutDTO postWorkout(WorkoutDTO workoutDTO){
        Workout workout = new Workout();

        workout.setDate(workoutDTO.getDate());
        workout.setDuration(workoutDTO.getDuration());
        workout.setCaloriesBurnt(workoutDTO.getCaloriesBurnt());
        workout.setType(workoutDTO.getType());

        Workout savedWorkout = workoutRepository.save(workout);

        return savedWorkout.getWorkoutDTO();
    }
}

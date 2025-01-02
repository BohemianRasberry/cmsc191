package com.cs191.fitnessTracker.service.workout;

import com.cs191.fitnessTracker.dto.ActivityDTO;
import com.cs191.fitnessTracker.dto.WorkoutDTO;
import com.cs191.fitnessTracker.entity.Activity;
import com.cs191.fitnessTracker.entity.Workout;
import com.cs191.fitnessTracker.repository.WorkoutRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<WorkoutDTO> getWorkouts(){
        List<Workout> workouts = workoutRepository.findAll();

        return workouts.stream().map(Workout::getWorkoutDTO).collect(Collectors.toList());
    }
}

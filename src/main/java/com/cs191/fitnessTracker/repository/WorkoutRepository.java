package com.cs191.fitnessTracker.repository;

import com.cs191.fitnessTracker.entity.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {
    @Query("SELECT SUM(w.duration) FROM Workout w")
    Integer getTotalWorkoutDuration();

    @Query("SELECT SUM(w.caloriesBurnt) FROM Workout w")
    Integer getTotalWorkoutCaloriesBurnt();

    @Query("SELECT w FROM Workout w ORDER BY w.date DESC")
    List<Workout> findLastSevenWorkouts(Pageable pageable);
}

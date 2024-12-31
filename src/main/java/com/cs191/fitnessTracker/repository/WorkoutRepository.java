package com.cs191.fitnessTracker.repository;

import com.cs191.fitnessTracker.entity.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {
}

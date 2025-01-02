package com.cs191.fitnessTracker.repository;

import com.cs191.fitnessTracker.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    @Query("SELECT SUM(a.steps) FROM Activity a")
    Integer getTotalSteps();

    @Query("SELECT SUM(a.distance) FROM Activity a")
    Double getTotalDistance();

    @Query("SELECT SUM(a.caloriesBurnt) FROM Activity a")
    Integer getTotalActivityCaloriesBurnt();

    @Query("SELECT a FROM Activity a ORDER BY a.date DESC")
    List<Activity> findLastSevenActivities(Pageable pageable);
}

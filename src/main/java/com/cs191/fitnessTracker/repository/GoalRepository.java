package com.cs191.fitnessTracker.repository;

import com.cs191.fitnessTracker.entity.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GoalRepository extends JpaRepository<Goal, Long> {
    @Query("SELECT COUNT(g) From Goal g WHERE g.achieved = true")
    Long countAchievedGoals();
    @Query("SELECT COUNT(g) From Goal g WHERE g.achieved = false")
    Long countNotAchievedGoals();
}

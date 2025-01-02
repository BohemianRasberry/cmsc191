package com.cs191.fitnessTracker.service.goal;

import com.cs191.fitnessTracker.dto.GoalDTO;

import java.util.List;

public interface GoalService {
    public GoalDTO postGoal(GoalDTO goalDTO);
    public List<GoalDTO> getGoals();
    public GoalDTO updateStatus(Long id);
}

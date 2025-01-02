package com.cs191.fitnessTracker.service.goal;

import com.cs191.fitnessTracker.dto.ActivityDTO;
import com.cs191.fitnessTracker.dto.GoalDTO;
import com.cs191.fitnessTracker.entity.Activity;
import com.cs191.fitnessTracker.entity.Goal;
import com.cs191.fitnessTracker.repository.GoalRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GoalServiceImplementation implements GoalService{

    private final GoalRepository goalRepository;

    public GoalServiceImplementation(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
    }

    public GoalDTO postGoal(GoalDTO goalDTO){
        Goal goal = new Goal();

        goal.setDescription(goalDTO.getDescription());
        goal.setStartDate(goalDTO.getStartDate());
        goal.setEndDate(goalDTO.getEndDate());
        goal.setAchieved(goalDTO.isAchieved());

        Goal savedGoal = goalRepository.save(goal);

        return savedGoal.getGoalDTO();
    }

    public List<GoalDTO> getGoals(){
        List<Goal> goals = goalRepository.findAll();

        return goals.stream().map(Goal::getGoalDTO).collect(Collectors.toList());
    }

    public GoalDTO updateStatus(Long id){
        Optional<Goal> optionalGoal = goalRepository.findById(id);

        if (optionalGoal.isPresent()){
            Goal existingGoal = optionalGoal.get();

            existingGoal.setAchieved(true);
            return goalRepository.save(existingGoal).getGoalDTO();
        } throw new EntityNotFoundException("Goal not found");
    }
}

package com.cs191.fitnessTracker.service.stats;

import com.cs191.fitnessTracker.dto.GraphDTO;
import com.cs191.fitnessTracker.dto.StatsDTO;
import com.cs191.fitnessTracker.entity.Activity;
import com.cs191.fitnessTracker.entity.Workout;
import com.cs191.fitnessTracker.repository.ActivityRepository;
import com.cs191.fitnessTracker.repository.GoalRepository;
import com.cs191.fitnessTracker.repository.WorkoutRepository;
import org.hibernate.graph.Graph;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatsServiceImplementation implements StatsService{
    private final GoalRepository goalRepository;
    private final ActivityRepository activityRepository;
    private final WorkoutRepository workoutRepository;

    public StatsServiceImplementation(GoalRepository goalRepository, ActivityRepository activityRepository, WorkoutRepository workoutRepository) {
        this.goalRepository = goalRepository;
        this.activityRepository = activityRepository;
        this.workoutRepository = workoutRepository;
    }

    public StatsDTO getStats(){
        Long achievedGoals = goalRepository.countAchievedGoals();
        Long notAchievedGoals = goalRepository.countNotAchievedGoals();

        Integer totalSteps = activityRepository.getTotalSteps();
        Double totalDistance = activityRepository.getTotalDistance();
        Integer totalActivityCaloriesBurnt = activityRepository.getTotalActivityCaloriesBurnt();

        Integer totalWorkoutDuration = workoutRepository.getTotalWorkoutDuration();
        Integer totalWorkoutCaloriesBurnt = workoutRepository.getTotalWorkoutCaloriesBurnt();

        int totalCaloriesBurnt = (totalActivityCaloriesBurnt != null ? totalActivityCaloriesBurnt : 0) +
                (totalWorkoutCaloriesBurnt != null ? totalWorkoutCaloriesBurnt : 0);

        StatsDTO statsDTO = new StatsDTO();
        statsDTO.setAchievedGoals(achievedGoals != null ? achievedGoals : 0);
        statsDTO.setNotAchievedGoals(notAchievedGoals != null ? notAchievedGoals : 0);

        statsDTO.setSteps(totalSteps != null ? totalSteps : 0);
        statsDTO.setDistance(totalDistance != null ? totalDistance : 0.0);
        statsDTO.setTotalCaloriesBurnt(totalCaloriesBurnt);
        statsDTO.setDuration(totalWorkoutDuration != null ? totalWorkoutDuration : 0);

        return statsDTO;
    }

    public GraphDTO getGraphStats() {
        Pageable pageable = PageRequest.of(0, 7);

        List<Workout> workouts = workoutRepository.findLastSevenWorkouts(pageable);
        List<Activity> activities = activityRepository.findLastSevenActivities(pageable);

        GraphDTO graphDTO = new GraphDTO();
        graphDTO.setWorkouts(workouts.stream().map(Workout::getWorkoutDTO).collect(Collectors.toList()));
        graphDTO.setActivities(activities.stream().map(Activity::getActivityDTO).collect(Collectors.toList()));

        return graphDTO;
    }
}

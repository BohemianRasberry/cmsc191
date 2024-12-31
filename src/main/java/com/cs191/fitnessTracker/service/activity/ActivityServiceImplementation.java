package com.cs191.fitnessTracker.service.activity;

import com.cs191.fitnessTracker.dto.ActivityDTO;
import com.cs191.fitnessTracker.entity.Activity;
import com.cs191.fitnessTracker.repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityServiceImplementation implements ActivityService{
    private final ActivityRepository activityRepository;

    public ActivityServiceImplementation(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public ActivityDTO postActivity(ActivityDTO activityDTO){
        Activity activity = new Activity();

        activity.setDate(activityDTO.getDate());
        activity.setDistance(activityDTO.getDistance());
        activity.setSteps(activityDTO.getSteps());
        activity.setCaloriesBurnt(activityDTO.getCaloriesBurnt());

        Activity savedActivity = activityRepository.save(activity);

        return savedActivity.getActivityDTO();
    }

    public List<ActivityDTO> getActivities(){
        List<Activity> activities = activityRepository.findAll();

        return activities.stream().map(Activity::getActivityDTO).collect(Collectors.toList());
    }
}

package com.cs191.fitnessTracker.entity;

import com.cs191.fitnessTracker.dto.ActivityDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date date;
    private int steps;
    private double distance;
    private int caloriesBurnt;

    public Activity() {
    }

    public Activity(Long id, Date date, int steps, double distance, int caloriesBurnt) {
        this.id = id;
        this.date = date;
        this.steps = steps;
        this.distance = distance;
        this.caloriesBurnt = caloriesBurnt;
    }

    public ActivityDTO getActivityDTO() {
        ActivityDTO activityDTO = new ActivityDTO();

        activityDTO.setId(id);
        activityDTO.setDate(date);
        activityDTO.setDistance(distance);
        activityDTO.setSteps(steps);
        activityDTO.setCaloriesBurnt(caloriesBurnt);

        return activityDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getCaloriesBurnt() {
        return caloriesBurnt;
    }

    public void setCaloriesBurnt(int caloriesBurnt) {
        this.caloriesBurnt = caloriesBurnt;
    }
}

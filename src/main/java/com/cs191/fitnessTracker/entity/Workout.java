package com.cs191.fitnessTracker.entity;

import com.cs191.fitnessTracker.dto.ActivityDTO;
import com.cs191.fitnessTracker.dto.WorkoutDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;
    private Date date;
    private int duration;
    private int caloriesBurnt;

    public WorkoutDTO getWorkoutDTO() {
        WorkoutDTO workoutDTO = new WorkoutDTO();

        workoutDTO.setId(id);
        workoutDTO.setType(type);
        workoutDTO.setDate(date);
        workoutDTO.setDuration(duration);
        workoutDTO.setCaloriesBurnt(caloriesBurnt);

        return workoutDTO;
    }

    public Workout() {
    }

    public Workout(Long id, String type, Date date, int duration, int caloriesBurnt) {
        this.id = id;
        this.type = type;
        this.date = date;
        this.duration = duration;
        this.caloriesBurnt = caloriesBurnt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getCaloriesBurnt() {
        return caloriesBurnt;
    }

    public void setCaloriesBurnt(int caloriesBurnt) {
        this.caloriesBurnt = caloriesBurnt;
    }
}

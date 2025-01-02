package com.cs191.fitnessTracker.entity;

import com.cs191.fitnessTracker.dto.GoalDTO;
import com.cs191.fitnessTracker.dto.WorkoutDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String description;
    private Date startDate;
    private Date endDate;
    private boolean achieved;

    public GoalDTO getGoalDTO() {
        GoalDTO goalDTO = new GoalDTO();

        goalDTO.setId(id);
        goalDTO.setDescription(description);
        goalDTO.setStartDate(startDate);
        goalDTO.setEndDate(endDate);
        goalDTO.setAchieved(achieved);

        return goalDTO;
    }

    public Goal() {
    }

    public Goal(Long id, String description, Date startDate, Date endDate, boolean achieved) {
        this.id = id;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.achieved = achieved;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isAchieved() {
        return achieved;
    }

    public void setAchieved(boolean achieved) {
        this.achieved = achieved;
    }
}

package com.cs191.fitnessTracker.dto;

public class StatsDTO {
    private Long achievedGoals;
    private Long notAchievedGoals;

    private int steps;
    private Double distance;
    private int totalCaloriesBurnt;

    private int duration;

    public Long getAchievedGoals() {
        return achievedGoals;
    }

    public void setAchievedGoals(Long achievedGoals) {
        this.achievedGoals = achievedGoals;
    }

    public Long getNotAchievedGoals() {
        return notAchievedGoals;
    }

    public void setNotAchievedGoals(Long notAchievedGoals) {
        this.notAchievedGoals = notAchievedGoals;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public int getTotalCaloriesBurnt() {
        return totalCaloriesBurnt;
    }

    public void setTotalCaloriesBurnt(int totalCaloriesBurnt) {
        this.totalCaloriesBurnt = totalCaloriesBurnt;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}

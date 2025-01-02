package com.cs191.fitnessTracker.service.stats;

import com.cs191.fitnessTracker.dto.GraphDTO;
import com.cs191.fitnessTracker.dto.StatsDTO;

public interface StatsService {
    public StatsDTO getStats();
    public GraphDTO getGraphStats();
}

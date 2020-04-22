package com.starlinks.experience.api.mission;

import com.starlinks.experience.api.goal.Goal;

import java.util.List;

public interface Mission {

    String getName();

    int getExperience();

    List<String> getDescription();

    List<Goal> getGoals();

}

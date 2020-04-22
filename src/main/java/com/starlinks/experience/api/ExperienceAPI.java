package com.starlinks.experience.api;

import com.starlinks.core.api.collections.Repository;
import com.starlinks.experience.LinkExperience;
import com.starlinks.experience.api.mission.Mission;
import com.starlinks.experience.api.prototype.Humanoid;

import java.util.UUID;

public interface ExperienceAPI {

    Repository<UUID, Humanoid> getHumanoids();

    Repository<String, Mission> getMissions();

    LinkExperience getPlugin();

}

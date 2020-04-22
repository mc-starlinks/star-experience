package com.starlinks.experience.sdk;

import com.starlinks.core.api.collections.Repository;
import com.starlinks.experience.LinkExperience;
import com.starlinks.experience.api.ExperienceAPI;
import com.starlinks.experience.api.mission.Mission;
import com.starlinks.experience.api.prototype.Humanoid;

import java.util.UUID;

public class WExperienceAPI implements ExperienceAPI {

    public Repository<UUID, Humanoid> getHumanoids() {
        return null;
    }

    public Repository<String, Mission> getMissions() {
        return null;
    }

    public LinkExperience getPlugin() {
        return null;
    }
}

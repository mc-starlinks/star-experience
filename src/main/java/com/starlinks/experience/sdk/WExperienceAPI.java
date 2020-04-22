package com.starlinks.experience.sdk;

import com.starlinks.core.api.collections.Repository;
import com.starlinks.experience.LinkExperience;
import com.starlinks.experience.api.ExperienceAPI;
import com.starlinks.experience.api.mission.Mission;
import com.starlinks.experience.api.prototype.Humanoid;
import com.starlinks.experience.sdk.repository.WHumanoidRepository;
import com.starlinks.experience.sdk.repository.mission.WMissionRepository;

import java.util.UUID;

public class WExperienceAPI implements ExperienceAPI {

    private static WExperienceAPI wExperienceAPI;

    public static WExperienceAPI getInstance() {
        if (wExperienceAPI == null) wExperienceAPI = new WExperienceAPI();

        return wExperienceAPI;
    }

    public Repository<UUID, Humanoid> getHumanoids() {
        return WHumanoidRepository.getInstance();
    }

    public Repository<String, Mission> getMissions() {
        return WMissionRepository.getInstance();
    }

    public LinkExperience getPlugin() {
        return LinkExperience.getInstance();
    }
}

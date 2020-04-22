package com.starlinks.experience.api.prototype;

import org.bukkit.entity.Player;

import java.util.UUID;

public interface Humanoid {

    UUID getUUID();

    Player getPlayer();

    int getExperience();

    short getLevel();

    void setExperience(int experience);

    void setLevel(short level);

}

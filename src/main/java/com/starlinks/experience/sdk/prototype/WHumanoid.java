package com.starlinks.experience.sdk.prototype;

import com.starlinks.experience.api.prototype.Humanoid;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

public class WHumanoid implements Humanoid {

    private final UUID uuid;
    private int experience;
    private short level;

    public WHumanoid(UUID uuid, int experience, short level) {
        this.uuid = uuid; this.experience = experience; this.level = level;
    }

    @Override
    public UUID getUUID() {
        return uuid;
    }

    @Override
    public Player getPlayer() {
        return Bukkit.getPlayer(uuid);
    }

    @Override
    public int getExperience() {
        return experience;
    }

    @Override
    public short getLevel() {
        return level;
    }

    @Override
    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public void setLevel(short level) {
        this.level = level;
    }
}

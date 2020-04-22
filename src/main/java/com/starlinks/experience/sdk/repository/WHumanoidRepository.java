package com.starlinks.experience.sdk.repository;

import com.starlinks.core.api.collections.Repository;
import com.starlinks.core.api.database.StarDatabaseProvider;
import com.starlinks.experience.LinkExperience;
import com.starlinks.experience.api.prototype.Humanoid;
import com.starlinks.experience.sdk.prototype.WHumanoid;

import java.util.Map;
import java.util.UUID;
import java.util.WeakHashMap;
import java.util.function.Supplier;

public class WHumanoidRepository implements Repository<UUID, Humanoid> {

    private final LinkExperience linkExperience = LinkExperience.getInstance();
    private final Map<UUID, Humanoid> humanoidMap = new WeakHashMap<>();

    public StarDatabaseProvider getProvider() {
        return linkExperience.getDatabaseProvider();
    }

    public void createProcedures(StarDatabaseProvider provider) {
        assert !provider.openAllConnections() : "Conexão com a tabela de experiencia não fornecida pelo database!";

        provider.update("CREATE TABLE IF NOT EXISTS experience(uuid CHAR(36), experience INT DEFAULT 0, level SMALLINT DEFAULT 0, name VARCHAR(20));");
    }

    public Humanoid find(UUID key) {
        Humanoid humanoid = humanoidMap.get(key);

        if(humanoid != null) return humanoid;

        Humanoid resource = getProvider().query("SELECT * FROM experience WHERE uuid = ?",
                set -> new WHumanoid(key, set.getInt("experience"), set.getShort("level")), key.toString()).orElse(new WHumanoid(key, 0, (short) 0));

        insert(resource);

        return resource;
    }

    public void insert(Humanoid instance) {
        getProvider().update("INSERT INTO experience(uuid, name) VALUES (?,?)", instance.getUUID().toString(), instance.getPlayer().getName());
    }

    public void update(Humanoid instance) {
        getProvider().update("UPDATE experience SET experience = ?, level = ? WHERE uuid = ?", instance.getExperience(), instance.getLevel(), instance.getUUID().toString());
    }

    public void insertOrUpdate(Humanoid instance) {
        throw new UnsupportedOperationException("Method not implemented.");
    }

    @Override
    public void findOrInsert(UUID key, Supplier<Humanoid> supplier) {
        throw new UnsupportedOperationException("Method not implemented.");
    }

    public void findAndDelete(UUID key) {
        throw new UnsupportedOperationException("Method not implemented.");
    }
}

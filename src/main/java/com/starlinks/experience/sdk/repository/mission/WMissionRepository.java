package com.starlinks.experience.sdk.repository.mission;

import com.starlinks.core.api.collections.Repository;
import com.starlinks.core.api.database.StarDatabaseProvider;
import com.starlinks.experience.LinkExperience;
import com.starlinks.experience.api.mission.Mission;
import com.starlinks.experience.json.deserializer.JSONDeserializer;
import com.starlinks.experience.json.serializer.JSONSerializer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.function.Supplier;

public class WMissionRepository implements Repository<String, Mission> {

    private final LinkExperience linkExperience = LinkExperience.getInstance();
    private final Map<String, Mission> missionMap = new WeakHashMap<>();

    private final JSONDeserializer<Mission> jsonDeserializer = new JSONDeserializer<>(Mission.class);
    private final JSONSerializer jsonSerializer = new JSONSerializer();

    private final Path path = linkExperience.getDataFolder().toPath();
    private final Path database = Paths.get(path.toUri() + "/missions");

    @Override
    public StarDatabaseProvider getProvider() {
        return linkExperience.getDatabaseProvider();
    }

    @Override
    public void createProcedures(StarDatabaseProvider provider) {
        if(!database.toFile().exists()) database.toFile().mkdirs();
    }

    @Override
    public Mission find(String key) {
        Mission mission = missionMap.get(key);

        if(mission != null) return mission;

        return jsonDeserializer.deserialize(new File(database.toFile(), key + ".json"));
    }

    @Override
    public void insert(Mission instance) {
        File file = new File(database.toFile(), instance.getName() + ".json");

        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } jsonSerializer.serialize(instance, file);
    }

    @Override
    public void update(Mission instance) {
        insert(instance);
    }

    public void insertOrUpdate(Mission instance) {
        throw new UnsupportedOperationException("Method not implemented.");
    }

    @Override
    public void findOrInsert(String key, Supplier<Mission> supplier) {
        throw new UnsupportedOperationException("Method not implemented.");
    }

    public void findAndDelete(String key) {
        throw new UnsupportedOperationException("Method not implemented.");
    }
}

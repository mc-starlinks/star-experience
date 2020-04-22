package com.starlinks.experience.json.deserializer;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JSONDeserializer<T> {

    private final Class<T> type;
    private final Gson gson = new Gson();

    public JSONDeserializer(Class<T> clazz) {
        this.type = clazz;
    }

    public T deserialize(File file) {
        try {
            gson.fromJson(new FileReader(file), type);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } return null;
    }
}

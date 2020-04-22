package com.starlinks.experience.json.serializer;

import com.google.common.io.Files;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;

public class JSONSerializer {

    private final Gson gson = new Gson();

    public void serialize(Object object, File file) {
        String bytes = gson.toJson(object);
        try {
            Files.write(bytes.getBytes(), file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

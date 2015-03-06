package com.akudreams.parser;

import com.akudreams.model.Item;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Reader;

public class JsonParser {

    public Item[] parse(Reader json) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Item.class, new ItemDeserialiser())
                .create();
        return gson.fromJson(json, Item[].class);
    }
}

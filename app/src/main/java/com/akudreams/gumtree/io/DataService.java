package com.akudreams.gumtree.io;

import android.content.Context;
import android.content.res.AssetManager;

import com.akudreams.model.Item;
import com.akudreams.parser.JsonParser;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.novoda.notils.logger.simple.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataService {
    static final String APPLICATIONS_FILE = "items.json";

    private final JsonParser responseParser;
    private final FileManager fileManager;

    public static DataService newInstance(Context context) {
        AssetManager assets = context.getAssets();
        FileManager fileManager = new FileManager(assets);
        JsonParser responseParser = new JsonParser();
        return new DataService(fileManager, responseParser);
    }

    DataService(FileManager fileManager, JsonParser responseParser) {
        this.fileManager = fileManager;
        this.responseParser = responseParser;
    }

    public List<Item> retrieveResponse() {
        Item[] response = null;
        try {
            response = responseParser.parse(fileManager.open(APPLICATIONS_FILE));
        } catch (JsonSyntaxException e) {
            Log.e(e, "Error parsing json");
        } catch (JsonIOException e) {
            Log.e(e, "Error parsing json");
        } catch (IllegalStateException e) {
            Log.e(e, "Error parsing json");
        }
        return response == null ? createNullSafeResponse() : Arrays.asList(response);
    }

    private List<Item> createNullSafeResponse() {
        return new ArrayList<Item>();
    }
}


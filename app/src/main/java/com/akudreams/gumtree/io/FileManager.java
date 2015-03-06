package com.akudreams.gumtree.io;

import android.content.res.AssetManager;

import com.novoda.notils.exception.DeveloperError;

import java.io.IOException;
import java.io.InputStreamReader;

public class FileManager {
    private static final String CHARSET = "UTF-8";

    private final AssetManager assetManager;

    public FileManager(AssetManager assetManager) {
        this.assetManager = assetManager;
    }

    public InputStreamReader open(String file) {
        try {
            return new InputStreamReader(assetManager.open(file), CHARSET);
        } catch (IOException e) {
            throw new DeveloperError("Failed to open file from Android Assets", e);
        }
    }
}

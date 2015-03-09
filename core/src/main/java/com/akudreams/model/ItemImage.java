package com.akudreams.model;

import java.io.Serializable;

public class ItemImage implements Serializable {
    private String url;

    public ItemImage(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}

package com.akudreams.model;

import java.io.Serializable;
import java.util.List;

public class Item implements Serializable {
    private List<ItemImage> images;
    private ItemOwner owner;
    private String title;
    private String price;
    private String location;
    private String description;
    private String datePosted;

    public Item(List<ItemImage> images, ItemOwner owner, String title, String price, String location, String description, String datePosted) {
        this.images = images;
        this.owner = owner;
        this.title = title;
        this.price = price;
        this.location = location;
        this.description = description;
        this.datePosted = datePosted;
    }

    public List<ItemImage> getImages() {
        return images;
    }

    public ItemOwner getOwner() {
        return owner;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public String getDatePosted() {
        return datePosted;
    }

}

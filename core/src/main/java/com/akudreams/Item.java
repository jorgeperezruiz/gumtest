package com.akudreams;

import java.util.List;

public class Item {
    private List<ItemImage> images;
    private ItemOwner owner;
    private String price;
    private String location;
    private String description;
    private String datePosted;

    public Item(List<ItemImage> images, ItemOwner owner, String price, String location, String description, String datePosted) {
        this.images = images;
        this.owner = owner;
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

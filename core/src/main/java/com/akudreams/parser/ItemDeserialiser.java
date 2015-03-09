package com.akudreams.parser;

import com.akudreams.model.Item;
import com.akudreams.model.ItemImage;
import com.akudreams.model.ItemOwner;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ItemDeserialiser implements JsonDeserializer<Item> {

    private enum ItemKey {
        OWNER("owner"),
        IMAGES("images"),
        NAME("name"),
        PRICE("price"),
        LOCATION("location"),
        TITLE("title"),
        DESCRIPTION("description"),
        DATE_POSTED("datePosted");

        private final String value;

        ItemKey(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }

    private enum UserKey {
        PHONE_NUMBER("phone_number"),
        EMAIL("email"),
        ACCOUNT_CREATION_DATE("account_creation_date"),
        NAME("name");

        private final String value;

        UserKey(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }

    @Override
    public Item deserialize(JsonElement rawJson, Type type, JsonDeserializationContext context) throws JsonParseException {
        // TODO Control safely the parse

        JsonObject json = rawJson.getAsJsonObject();

        List<ItemImage> images = deserializeImages(json.get(ItemKey.IMAGES.value()).getAsJsonArray());
        ItemOwner owner = deserializeOwner(json.get(ItemKey.OWNER.value()).getAsJsonObject());
        String price = json.get(ItemKey.PRICE.value()).getAsString();
        String location = json.get(ItemKey.LOCATION.value()).getAsString();
        String title = json.get(ItemKey.TITLE.value()).getAsString();
        String description = json.get(ItemKey.DESCRIPTION.value()).getAsString();
        String datePosted = json.get(ItemKey.DATE_POSTED.value()).getAsString();

        return new Item(images, owner, title, price, location, description, datePosted);
    }

    private ItemOwner deserializeOwner(JsonObject json) {
        String phone = json.get(UserKey.PHONE_NUMBER.value()).getAsString();
        String email = json.get(UserKey.EMAIL.value()).getAsString();
        String creationDate = json.get(UserKey.ACCOUNT_CREATION_DATE.value()).getAsString();
        String name = json.get(UserKey.NAME.value()).getAsString();

        return new ItemOwner(name, phone, email, creationDate);
    }

    private List<ItemImage> deserializeImages(JsonArray jsonArray) {
        List<ItemImage> images = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            images.add(new ItemImage(jsonArray.get(i).getAsString()));
        }
        return images;
    }
}

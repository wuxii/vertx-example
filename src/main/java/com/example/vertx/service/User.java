package com.example.vertx.service;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author wuxii
 */
@DataObject(generateConverter = true)
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String username;

    public User(User user) {
        this.username = user.getUsername();
    }

    public User(JsonObject json) {
        // UserConverter.fromJson(json, this);
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public JsonObject toJson() {
        final JsonObject json = new JsonObject();
        // UserConverter.toJson(this, json);
        return json;
    }
}

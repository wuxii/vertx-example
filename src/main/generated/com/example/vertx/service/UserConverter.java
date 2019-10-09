package com.example.vertx.service;

import io.vertx.core.json.JsonObject;
import io.vertx.core.json.JsonArray;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import io.vertx.core.spi.json.JsonCodec;

/**
 * Converter and Codec for {@link com.example.vertx.service.User}.
 * NOTE: This class has been automatically generated from the {@link com.example.vertx.service.User} original class using Vert.x codegen.
 */
public class UserConverter implements JsonCodec<User, JsonObject> {

  public static final UserConverter INSTANCE = new UserConverter();

  @Override public JsonObject encode(User value) { return (value != null) ? value.toJson() : null; }

  @Override public User decode(JsonObject value) { return (value != null) ? new User(value) : null; }

  @Override public Class<User> getTargetClass() { return User.class; }

  public static void fromJson(Iterable<java.util.Map.Entry<String, Object>> json, User obj) {
    for (java.util.Map.Entry<String, Object> member : json) {
      switch (member.getKey()) {
        case "username":
          if (member.getValue() instanceof String) {
            obj.setUsername((String)member.getValue());
          }
          break;
      }
    }
  }

  public static void toJson(User obj, JsonObject json) {
    toJson(obj, json.getMap());
  }

  public static void toJson(User obj, java.util.Map<String, Object> json) {
    if (obj.getUsername() != null) {
      json.put("username", obj.getUsername());
    }
  }
}

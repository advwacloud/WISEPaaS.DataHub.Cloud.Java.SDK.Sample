package main;

import java.time.Instant;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

public final class GsonFactory {

    private static final Gson GSON;

    /** private constructor for utility class */
    private GsonFactory() {
    }

    static class InstantTypeConverter implements JsonSerializer<Instant>, JsonDeserializer<Instant> {

        @Override
        public JsonElement serialize(Instant src, Type srcType, JsonSerializationContext context) {
            return new JsonPrimitive(src.toString());
        }

        @Override
        public Instant deserialize(JsonElement json, Type type, JsonDeserializationContext context) {
            return Instant.parse(json.getAsString());
        }
    }

    static {

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Instant.class, new InstantTypeConverter());
        GSON = builder.create();
    }

    /**
     * Get the Gson instance
     * 
     * @return the Gson instance
     */
    public static Gson getGson() {
        return GSON;
    }
}
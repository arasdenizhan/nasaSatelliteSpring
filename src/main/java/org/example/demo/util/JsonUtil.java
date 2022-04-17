package org.example.demo.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.apache.logging.log4j.util.Strings;

import java.util.Objects;

public class JsonUtil {
    private JsonUtil(){
        throw new UnsupportedOperationException("You can not create an object of JsonUtil class.");
    }

    public static String getJsonFieldValue(JsonObject jsonObject, String field){
        JsonElement jsonElement = jsonObject.get(field);
        return Objects.isNull(jsonElement) ? Strings.EMPTY : jsonElement.getAsString();
    }
}

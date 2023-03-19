package com.example;

import java.util.Map;

public class DynamicObject {
    private Map<String, Object> properties;

    public DynamicObject(Map<String, Object> properties) {
        this.properties = properties;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            builder.append(key);
            builder.append(": ");
            builder.append(value.toString());
            builder.append(", ");

        }
        builder.delete(builder.length() - 2, builder.length());
        return builder.toString();
    }

}

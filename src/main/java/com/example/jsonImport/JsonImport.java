package com.example.jsonImport;

import com.example.DynamicObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class JsonImport {

    public static ObjectMapper objectMapper = new ObjectMapper();

    public static File file;

    public static List<Object> JsonFileToObject(File file) throws IOException {

// Create ObjectMapper object
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(file);
        if (rootNode.isObject()) {
// Read JSON file and convert to Map
            Map<String, Object> map = mapper.readValue(file, HashMap.class);
// Create Java object
            Map<String, Object> properties = new HashMap<>();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                properties.put(key, value);
            }
            // Create a new Java object using the properties map
            DynamicObject object = new DynamicObject(properties);
            return Collections.singletonList(object);

        } else if (rootNode.isArray()) {
            List<Map<String, Object>> data = mapper.readValue(file, new TypeReference<List<Map<String, Object>>>() {
            });

            List<Object> objects = new ArrayList<>();
            for (Map<String, Object> map : data) {
                Object object = new DynamicObject(map);
                objects.add(object);
            }
                return objects;
            }

 return null;
        }


    }

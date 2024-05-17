package com.shortthirdman.leetcode.quickstart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class JsonComparator {
	
	private final Gson gson;
	
	public JsonComparator() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setDateFormat("yyyy-MM-dd HH:mm:ss");
		gsonBuilder.serializeNulls();
		gsonBuilder.setPrettyPrinting();

		// Create and return the custom Gson instance
		this.gson = gsonBuilder.create();
	}

	public List<String> findDifferentKeys(String json1, String json2) {
		Set<String> differentKeys = new HashSet<>();
		
		JsonObject jsonObject1 = gson.fromJson(json1, JsonObject.class);
        JsonObject jsonObject2 = gson.fromJson(json2, JsonObject.class);
        
        for (String key : jsonObject1.keySet()) {
            if (jsonObject2.has(key)) {
                JsonElement value1 = jsonObject1.get(key);
                JsonElement value2 = jsonObject2.get(key);
                if (!value1.equals(value2)) {
                    differentKeys.add(key);
                }
            }
        }

        List<String> sortedKeys = new ArrayList<>(differentKeys);
        Collections.sort(sortedKeys);
        
        return sortedKeys;
	}
}

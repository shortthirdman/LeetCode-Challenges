package com.shortthirdman.leetcode.quickstart;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JsonComparatorTest {
	
	JsonComparator app;
	
	@BeforeEach
	public void setUp() {
		app = new JsonComparator();
	}

	@Test
    public void testFindDifferentKeys_SameJson() {
        String json1 = "{\"key1\": \"value1\", \"key2\": \"value2\", \"key3\": \"value3\"}";
        String json2 = "{\"key1\": \"value1\", \"key2\": \"value2\", \"key3\": \"value3\"}";
        assertEquals(0, app.findDifferentKeys(json1, json2).size());
    }

    @Test
    public void testFindDifferentKeys_OneDifferentValue() {
        String json1 = "{\"key1\": \"value1\", \"key2\": \"value2\", \"key3\": \"value3\"}";
        String json2 = "{\"key1\": \"value1\", \"key2\": \"new_value2\", \"key3\": \"value3\"}";
        assertEquals(1, app.findDifferentKeys(json1, json2).size());
    }

    @Test
    public void testFindDifferentKeys_AllDifferentValues() {
        String json1 = "{\"key1\": \"value1\", \"key2\": \"value2\", \"key3\": \"value3\"}";
        String json2 = "{\"key1\": \"new_value1\", \"key2\": \"new_value2\", \"key3\": \"new_value3\"}";
        assertEquals(3, app.findDifferentKeys(json1, json2).size());
    }

    @Test
    public void testFindDifferentKeys_MissingKeys() {
        String json1 = "{\"key1\": \"value1\", \"key2\": \"value2\", \"key3\": \"value3\"}";
        String json2 = "{\"key1\": \"value1\", \"key3\": \"value3\"}";
        assertNotEquals(1, app.findDifferentKeys(json1, json2).size());
        assertEquals(0, app.findDifferentKeys(json1, json2).size());
    }
}

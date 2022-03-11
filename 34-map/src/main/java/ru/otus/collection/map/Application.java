package ru.otus.collection.map;

import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Map<String, String> myMap = new MapImpl<>();
        myMap.put("key", "value");
        String value = myMap.get("key");

        System.out.println(value);
    }
}

package ru.otus.collection.map;

import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Map<String, String> myMap = new MapImpl<>();
        myMap.put("key1", "value1");
        myMap.put("key2", "value2");
        myMap.put("key3", "value3");
        myMap.put("key4", "value4");
        myMap.put("key5", "value5");
        myMap.put("key6", "value6");
        myMap.put("key7", "value7");

        for (int i = 0; i < 7; i++) {
            String val = myMap.get("key" + (i + 1));
            System.out.println(val);
        }
    }
}

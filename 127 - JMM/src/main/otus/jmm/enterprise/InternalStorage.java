package main.otus.jmm.enterprise;


import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InternalStorage {

    Map<String, String> threadSafeMap = new ConcurrentHashMap<>();
//    Map<String, String> map = new HashMap<>();

    String getData(String name) {
        return threadSafeMap.get(name);
    }

    String putData(String name, String value) {
        return threadSafeMap.put(name, value);
    }

}

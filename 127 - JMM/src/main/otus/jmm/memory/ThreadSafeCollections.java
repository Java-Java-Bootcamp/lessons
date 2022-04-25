package main.otus.jmm.memory;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadSafeCollections {
    //locked at bucket level -> works quicker
    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

    //each method synchronized -> pretty slow
    Map<String, String> map = Collections.synchronizedMap(new HashMap<String,String>());

}

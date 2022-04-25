package main.otus.jmm.enterprise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class MyController {

    @Autowired
    ExternalStorage externalStorage;
    @Autowired
    InternalStorage internalStorage;

    @GetMapping("/external")
    public String getInternalData(@PathParam("name") String name) {
        return externalStorage.getData(name);
    }

    @GetMapping("/internal")
    public String getExternalData(@PathParam("name") String name) {
        return internalStorage.getData(name);
    }

    @PostMapping("/external")
    public String postExternalData(@PathParam("name") String name, @PathParam("value") String value) {
        externalStorage.putData(name, value);
        return "OK";
    }

    @PostMapping("/internal")
    public String postInternalData(@PathParam("name") String name, @PathParam("value") String value) {
        internalStorage.putData(name, value);
        return "OK";
    }
}

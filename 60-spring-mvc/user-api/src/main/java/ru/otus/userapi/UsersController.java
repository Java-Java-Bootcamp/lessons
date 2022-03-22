package ru.otus.userapi;

import java.util.List;
import jdk.jfr.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

  @Autowired
  UsersService service;

  @GetMapping("/users")
  public List<User> getAllUsers() {
    List<User> users = service.getAllUsers();

    return users;
  }

  @GetMapping("/users/{account}")
  public User getUser(@PathVariable String account) {
    return service.getUser(account);
  }

  @PostMapping("/users")
  public void createUser(@RequestBody User newUser){
    service.createUser(newUser);
  }

}

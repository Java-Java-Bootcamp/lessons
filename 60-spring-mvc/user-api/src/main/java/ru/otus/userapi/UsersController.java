package ru.otus.userapi;

import java.util.List;
import jdk.jfr.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

  @PutMapping("/users/{account}")
  public void updateUser(@PathVariable String account, @RequestBody User newUser){
    if (!account.equals(newUser.getAccount())) {
      throw new RuntimeException("Недопустимое имя пользователя");
    }

    service.updateUser(newUser);
  }

  @DeleteMapping("/users/{account}")
  public void deleteUser(@PathVariable String account){
    service.deleteUser(account);
  }
}

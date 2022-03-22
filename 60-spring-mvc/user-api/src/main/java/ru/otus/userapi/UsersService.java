package ru.otus.userapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

  private List<User> users  = new ArrayList<>() {{
    add(new User("agafonov", "Олег", "Агафонов"));
  }};

  public List<User> getAllUsers() {
    return users;
  }

  public User getUser(String account) {

    // 1. поиск с помощью цикла
//    for (User user : users) {
//      if (user.getAccount().equals(account)) {
//        return user;
//      }
//    }

    //2. поиск с помощью Stream API
    Optional<User> user = users.stream().filter(u -> u.getAccount().equals(account)).findFirst();
    return user.orElse(null);
  }

  public void createUser(User newUser) {
    users.add(newUser);
  }

  public void updateUser(User newUser){
    User user = getUser(newUser.getAccount());
    user.setName(newUser.getName());
    user.setLastname(newUser.getLastname());
  }

  public void deleteUser(String account) {
    User user = getUser(account);
    if (user != null) {
      users.remove(user);
    }
  }
}

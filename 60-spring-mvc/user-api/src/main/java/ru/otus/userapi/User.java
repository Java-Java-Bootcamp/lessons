package ru.otus.userapi;

public class User {

  private String account;
  private String name;
  private String lastname;

  public User(String account, String name, String lastname) {
    this.account = account;
    this.name = name;
    this.lastname = lastname;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getName() {
    return name;
  }

  public String getLastname() {
    return lastname;
  }

  public String getAccount(){
    return account;
  }

}

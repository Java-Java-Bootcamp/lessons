package ru.otus.sprindemo.model;

import java.math.BigDecimal;
import java.util.UUID;

public class Account {
    private UUID id;

    private User user;

    private AccountState state;

    public Account(UUID id, User user) {
        this.id = id;
        this.user = user.clone();
    }

    public UUID getId() {
        return id;
    }

    public String getUserName() {
        return user.getFirstName();
    }

    public String getUserSurname() {
        return user.getLastName();
    }

    public String getUserFullName() {
        return user.getFullName();
    }

    public String getUserShortName() {
        return String.format("%s %s.", user.getLastName(), user.getFirstName().charAt(0));
    }

    public AccountState getState() {
        return state;
    }

    public void changeState(BigDecimal amount) {
        this.state.changeState(amount);
    }
}

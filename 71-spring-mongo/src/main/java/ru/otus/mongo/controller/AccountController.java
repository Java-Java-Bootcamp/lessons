package ru.otus.mongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.mongo.repository.dto.Account;
import ru.otus.mongo.repository.dto.User;
import ru.otus.mongo.service.AccountService;

import java.util.UUID;

@RestController
public class AccountController {
    @Autowired
    private AccountService service;

    @GetMapping("*")
    public void getAccount() {
        service.getAccounts();
    }

    @PostMapping("*")
    public void setAccount() {
        Account account = new Account();
        account.setAmount(10);

        User user = new User();
        user.setName("name");
        user.setLastName("last name");
        user.setAge(2);
        account.setUser(user);

        service.addAccount(account);
    }
}

package ru.otus.sprindemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.otus.sprindemo.model.Account;
import ru.otus.sprindemo.repository.dto.UserDTO;
import ru.otus.sprindemo.service.AccountService;

import java.util.List;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService service;

    @GetMapping("/state")
    public Account getAccountState(@RequestParam(value = "id") long id) {
        service.getAccount();
        return null;
    }

    @GetMapping("/user")
    public UserDTO getAccountState(@RequestParam(value = "email") String email) {
        return service.getUser(email);
    }

    @PostMapping("/transaction")
    public void makeTransaction() {

    }
}

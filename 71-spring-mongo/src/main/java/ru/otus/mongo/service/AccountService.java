package ru.otus.mongo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.mongo.repository.AccountRepository;
import ru.otus.mongo.repository.dto.Account;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repository;

    public void getAccounts() {
        List<Account> accounts = repository.findAll();
        int i = 0;
    }

    public void addAccount(Account account) {
        repository.save(account);
    }
}

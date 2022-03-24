package ru.otus.sprindemo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.sprindemo.model.Account;
import ru.otus.sprindemo.repository.AccountRepository;
import ru.otus.sprindemo.repository.dto.UserDTO;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository repository;

    public void getAccount() {
        Optional<Account> res = repository.findAccount("pupkin semen", "mail@email.test", "+79991112345");
        int i = 0;
    }

    public UserDTO getUser(String email) {
        UserDTO result = repository.findUserByEmail(email);
        return result;
    }
}

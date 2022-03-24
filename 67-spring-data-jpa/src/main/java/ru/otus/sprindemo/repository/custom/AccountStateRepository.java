package ru.otus.sprindemo.repository.custom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import ru.otus.sprindemo.model.Account;
import ru.otus.sprindemo.repository.dto.AccountDTO;

import java.util.Optional;
import java.util.UUID;

@NoRepositoryBean
public interface AccountStateRepository extends JpaRepository<AccountDTO, UUID> {
    public void saveAccountState(Account account);

    public Optional<Account> findAccount(String fullName, String email, String phone);
}

package ru.otus.sprindemo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.otus.sprindemo.repository.custom.AccountStateRepository;
import ru.otus.sprindemo.repository.dto.UserDTO;

public interface AccountRepository extends AccountStateRepository {

    @Query("SELECT u FROM users u WHERE u.email = :email")
    UserDTO findUserByEmail(@Param("email") String email);
}

package ru.otus.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.mongo.repository.dto.Account;

import java.util.UUID;

public interface AccountRepository extends MongoRepository<Account, String> {
}

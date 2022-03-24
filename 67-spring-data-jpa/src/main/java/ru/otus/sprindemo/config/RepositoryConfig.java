package ru.otus.sprindemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ru.otus.sprindemo.repository.custom.AccountStateRepositoryImpl;

@Configuration
@EnableJpaRepositories(
        basePackages = "ru.otus.sprindemo.repository",
        repositoryBaseClass = AccountStateRepositoryImpl.class
)
public class RepositoryConfig {
}

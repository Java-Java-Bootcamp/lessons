package ru.otus.sprindemo.repository.custom;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import ru.otus.sprindemo.model.Account;
import ru.otus.sprindemo.model.User;
import ru.otus.sprindemo.repository.dto.AccountDTO;
import ru.otus.sprindemo.repository.dto.UserDTO;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class AccountStateRepositoryImpl extends SimpleJpaRepository<AccountDTO, UUID> implements AccountStateRepository {

    private final EntityManager em;

    public AccountStateRepositoryImpl(JpaEntityInformation<AccountDTO, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.em = entityManager;
    }

    @Transactional
    @Override
    public void saveAccountState(Account account) {

    }

    @Override
    public Optional<Account> findAccount(String fullName, String email, String phone) {
        String[] nameParts = fullName.split(" ");

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<UserDTO> cQuery = builder.createQuery(UserDTO.class);
        Root<UserDTO> root = cQuery.from(UserDTO.class);
        cQuery
                .select(root)
                .where(
                        builder.and(
                                builder.like(builder.upper(root.get("firstName")), "%" + nameParts[1].toUpperCase() + "%"),
                                builder.like(builder.upper(root.get("lastName")), "%" + nameParts[0].toUpperCase() + "%"),
                                builder.equal(root.<String>get("email"), email),
                                builder.equal(root.<String>get("phone"), phone)
                        )
                );

        TypedQuery<UserDTO> query = em.createQuery(cQuery);

        UserDTO result = query.getResultList().get(0);

        User user = User.builder()
                .firstName(result.getFirstName())
                .lastName(result.getLastName())
                .email(result.getEmail())
                .phone(result.getPhone())
                .build();

        Account account = new Account(result.getAccount().getId(), user);

        return Optional.of(account);
    }
}

package ru.otus.sprindemo.repository.dto;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity(name = "accounts")
public class AccountDTO {
    @Id
    private UUID id;

    private BigDecimal state;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserDTO user;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal getState() {
        return state;
    }

    public void setState(BigDecimal state) {
        this.state = state;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}

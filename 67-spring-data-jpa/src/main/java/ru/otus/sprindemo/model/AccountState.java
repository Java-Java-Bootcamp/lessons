package ru.otus.sprindemo.model;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class AccountState {
    private BigDecimal currentAmount = BigDecimal.ZERO;

    public void changeState(BigDecimal amount) {
        currentAmount = currentAmount.add(amount);
    }
}

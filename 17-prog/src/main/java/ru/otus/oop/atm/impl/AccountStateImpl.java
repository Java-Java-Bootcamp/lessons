package ru.otus.oop.atm.impl;

import ru.otus.oop.atm.interfaces.AccountState;

public class AccountStateImpl implements AccountState {
    private int amount = 0;

    @Override
    public void printState() {
        System.out.printf("Current state: %d%n", amount);
    }

    @Override
    public boolean canGetMoney(int value) {
        return amount >= value;
    }

    @Override
    public int availableAmount() {
        return amount;
    }

    @Override
    public void changeAmount(int value) {
        amount += value;
    }
}

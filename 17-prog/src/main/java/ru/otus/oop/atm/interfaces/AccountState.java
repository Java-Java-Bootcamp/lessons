package ru.otus.oop.atm.interfaces;

public interface AccountState {
    void printState();

    boolean canGetMoney();

    void changeAmount(int value);

    int availableAmount();
}

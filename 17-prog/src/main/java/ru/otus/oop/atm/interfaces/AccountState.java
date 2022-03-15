package ru.otus.oop.atm.interfaces;

public interface AccountState {
    void printState();

    boolean canGetMoney(int value);

    void changeAmount(int value);

    int availableAmount();
}

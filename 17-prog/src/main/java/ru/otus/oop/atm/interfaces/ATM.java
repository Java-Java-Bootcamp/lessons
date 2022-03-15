package ru.otus.oop.atm.interfaces;

import ru.otus.oop.atm.dictionary.Denomination;

public interface ATM {
    void withdraw(int amount);

    void depositMoney(Denomination denomination, int amount);

    AccountState accountState();

    void saveState();

    void load();
}

package ru.otus.oop.atm.interfaces;

import ru.otus.oop.atm.dictionary.Denomination;

public interface MoneyCell {
    Denomination cellDenomination();

    void putMoney(int amount) throws Exception;

    boolean canPut(int amount);

    void getMoney(int amount) throws Exception;

    boolean canGet(int amount);

    void saveState();
}

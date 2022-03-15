package ru.otus.oop.atm.interfaces;

import ru.otus.oop.atm.dictionary.Denomination;

public interface MoneyCell {
    Denomination cellDenomination();

    void putMoney(int amount);

    boolean canPut(int amount);

    void getMoney(int amount);

    boolean canGet(int amount);

    void saveState();

    void saveStateAsJackson();

    MoneyCell deserialize();

    MoneyCell deserializeFromJson();
}

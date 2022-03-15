package ru.otus.oop.atm.util;

import ru.otus.oop.atm.dictionary.Denomination;

public class BanknotesNumber {
    private final int banknotes;
    private final Denomination denomination;

    public BanknotesNumber(int banknotes, Denomination denomination) {
        this.banknotes = banknotes;
        this.denomination = denomination;
    }

    public int getBanknotes() {
        return banknotes;
    }

    public Denomination getDenomination() {
        return denomination;
    }
}

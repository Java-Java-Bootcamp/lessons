package ru.otus.oop.atm.impl.money.cell;

import ru.otus.oop.atm.dictionary.Denomination;

public class HundredMoneyCell extends AbstractMoneyCell {
    private final Denomination denomination = Denomination.HUNDRED;

    public HundredMoneyCell(int maxNumber) {
        super(maxNumber);
    }

    @Override
    public Denomination cellDenomination() {
        return denomination;
    }
}

package ru.otus.oop.atm.impl.money.cell;

import ru.otus.oop.atm.dictionary.Denomination;

public class FiveHundredMoneyCell extends AbstractMoneyCell {
    private final Denomination denomination = Denomination.FIVE_HUNDRED;

    public FiveHundredMoneyCell(int maxNumber) {
        super(maxNumber);
    }

    @Override
    public Denomination cellDenomination() {
        return denomination;
    }
}

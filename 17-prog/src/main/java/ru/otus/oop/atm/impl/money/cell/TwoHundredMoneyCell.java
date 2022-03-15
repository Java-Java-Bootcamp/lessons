package ru.otus.oop.atm.impl.money.cell;

import ru.otus.oop.atm.dictionary.Denomination;

public class TwoHundredMoneyCell extends AbstractMoneyCell {
    private final Denomination denomination = Denomination.TWO_HUNDRED;

    public TwoHundredMoneyCell(int maxNumber) {
        super(maxNumber);
    }

    @Override
    public Denomination cellDenomination() {
        return denomination;
    }
}

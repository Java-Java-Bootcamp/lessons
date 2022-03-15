package ru.otus.oop.atm.impl.money.cell;

import ru.otus.oop.atm.dictionary.Denomination;

public class ThousandMoneyCell extends AbstractMoneyCell {
    private final Denomination denomination = Denomination.THOUSAND;

    public ThousandMoneyCell(int maxNumber) {
        super(maxNumber);
    }

    @Override
    public Denomination cellDenomination() {
        return denomination;
    }
}

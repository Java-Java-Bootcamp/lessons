package ru.otus.oop.atm.impl.money.cell;

import ru.otus.oop.atm.dictionary.Denomination;

public class FiftyMoneyCell extends AbstractMoneyCell {
    private final Denomination denomination = Denomination.FIFTY;

    public FiftyMoneyCell(int maxNumber) {
        super(maxNumber);
    }

    @Override
    public Denomination cellDenomination() {
        return denomination;
    }
}

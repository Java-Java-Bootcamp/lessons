package ru.otus.oop.atm.impl.money.cell;

import ru.otus.oop.atm.dictionary.Denomination;

public class FiveThousandMoneyCell extends AbstractMoneyCell {
    private final Denomination denomination = Denomination.FIVE_THOUSAND;

    public FiveThousandMoneyCell(int maxNumber) {
        super(maxNumber);
    }

    @Override
    public Denomination cellDenomination() {
        return denomination;
    }
}

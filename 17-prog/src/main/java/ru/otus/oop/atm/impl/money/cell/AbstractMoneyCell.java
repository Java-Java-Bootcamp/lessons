package ru.otus.oop.atm.impl.money.cell;

import ru.otus.oop.atm.interfaces.MoneyCell;

public abstract class AbstractMoneyCell implements MoneyCell {
    private int maxNumber;
    private int banknotesNumber;

    public AbstractMoneyCell(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    @Override
    public void putMoney(int amount) {
        if (canPut(amount)) {
            banknotesNumber += amount;
        }
    }

    @Override
    public boolean canPut(int amount) {
        return maxNumber - banknotesNumber >= amount;
    }

    @Override
    public void getMoney(int amount) throws Exception {
        if (canGet(amount)) {
            banknotesNumber -= amount;
        }
    }

    @Override
    public boolean canGet(int amount) {
        return banknotesNumber >= amount;
    }

    @Override
    public void saveState() {
        // TODO сохранить состояние ячейки
    }
}

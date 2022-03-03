package ru.otus.oop.atm.impl;

import ru.otus.oop.atm.dictionary.Denomination;
import ru.otus.oop.atm.exception.AccountStateException;
import ru.otus.oop.atm.exception.MoneyCellException;
import ru.otus.oop.atm.impl.money.cell.*;
import ru.otus.oop.atm.interfaces.ATM;
import ru.otus.oop.atm.interfaces.AccountState;
import ru.otus.oop.atm.interfaces.MoneyCell;
import ru.otus.oop.atm.util.BanknotesNumber;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AutomatedTellerMachine implements ATM {
    private final AccountState state = new AccountStateImpl();
    private final List<MoneyCell> cells = new ArrayList<>();

    public AutomatedTellerMachine() {
        cells.add(new FiftyMoneyCell(10));
        cells.add(new FiveHundredMoneyCell(10));
        cells.add(new FiveHundredMoneyCell(10));
        cells.add(new HundredMoneyCell(10));
        cells.add(new ThousandMoneyCell(10));
        cells.add(new TwoHundredMoneyCell(10));
        cells.add(new TwoThousandMoneyCell(10));
    }

    @Override
    public void withdraw(int amount) throws Exception {
        if (state.availableAmount() < amount) {
            throw new AccountStateException("No enough money");
        }

        List<BanknotesNumber> banknotes = new ArrayList<>();
        for (Denomination value : Denomination.values()) {
            int number = amount / value.getMultiplier();
            banknotes.add(new BanknotesNumber(number, value));
        }

        banknotes.sort(Comparator.comparingInt(BanknotesNumber::getBanknotes));

        List<BanknotesNumber> availableBanknotes = banknotes.stream().filter(banknotesNumber -> banknotesNumber.getBanknotes() > 0).toList();

        if (availableBanknotes.size() == 0) {
            throw new MoneyCellException("Can not withdraw. Sum must be a multiple of 50");
        }

        // TODO проверка наличия купюр в ячейках и печать сколько каких купюр выдано.
    }

    @Override
    public void depositMoney(Denomination denomination, int amount) throws Exception {
        cells.stream().filter(moneyCell -> moneyCell.cellDenomination().equals(denomination)).findFirst().get().putMoney(amount);
        state.changeAmount(amount);
    }

    @Override
    public AccountState accountState() {
        return state;
    }
}
